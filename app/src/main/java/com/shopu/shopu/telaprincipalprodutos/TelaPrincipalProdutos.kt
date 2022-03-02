package com.shopu.shopu.telaprincipalprodutos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.shopu.shopu.Adapter.AdapterProduto
import com.shopu.shopu.R
import com.shopu.shopu.databinding.ActivityTelaprincipaldeprodutosBinding
import com.shopu.shopu.dialog.DialogPerfilUsuario
import com.shopu.shopu.formloguim.FormLogin
import com.shopu.shopu.model.Produto

class TelaPrincipalProdutos : AppCompatActivity() {

    lateinit var biding: ActivityTelaprincipaldeprodutosBinding
    lateinit var adapterProduto: AdapterProduto
             var lista_produtos: MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityTelaprincipaldeprodutosBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Main)
        setContentView(biding.root)

        val recycler_produtos = biding.recycleProdutos
        recycler_produtos.layoutManager = GridLayoutManager(this,2)
        recycler_produtos.setHasFixedSize(true)
        adapterProduto = AdapterProduto(this,lista_produtos)
        recycler_produtos.adapter = adapterProduto

        itensDelista()

    }
    fun itensDelista(){
        val produto1 = Produto(R.drawable.logo,"Sapato de couro","R$150,00")
        lista_produtos.add(produto1)

        val produto2 = Produto(R.drawable.logo,"Sapato de couro","R$150,00")
        lista_produtos.add(produto2)

        val produto3 = Produto(R.drawable.logo,"Sapato de couro","R$150,00")
        lista_produtos.add(produto3)

        val produto4 = Produto(R.drawable.logo,"Sapato de couro","R$150,00")
        lista_produtos.add(produto4)

        val produto5 = Produto(R.drawable.logo,"Sapato de couro","R$150,00")
        lista_produtos.add(produto5)

        val produto6 = Produto(R.drawable.logo,"Spat de couro","R$150,00")
        lista_produtos.add(produto6)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.perfil -> iniciarDialogPerfilUsuario()
            R.id.pedidos -> Log.d("p", "Pedidos")
            R.id.deslogar -> deslogarUsuario()
        }

        return super.onOptionsItemSelected(item)
    }

        private fun iniciarDialogPerfilUsuario() {
        val dialogPerfilUsuario = DialogPerfilUsuario(this)
        dialogPerfilUsuario.iniciarPerfilUsuario()
        dialogPerfilUsuario.recuperarDadosUsuarioBanco()
    }

    private fun deslogarUsuario() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}