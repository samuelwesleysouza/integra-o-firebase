package com.shopu.shopu.telaprincipalprodutos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.shopu.shopu.R
import com.shopu.shopu.dialog.DialogPerfilUsuario
import com.shopu.shopu.formloguim.FormLogin

class TelaPrincipalProdutos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Main)
        setContentView(R.layout.activity_telaprincipaldeprodutos)
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
        dialogPerfilUsuario.recuperarDadosUsuariosBanco()
    }

    private fun deslogarUsuario() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }

}