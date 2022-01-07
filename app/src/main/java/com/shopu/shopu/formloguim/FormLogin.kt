package com.shopu.shopu.formloguim

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.shopu.shopu.R
import com.shopu.shopu.databinding.ActivityFormloginBinding
import com.shopu.shopu.formcadastro.FormCadastro
import com.shopu.shopu.telaprincipalprodutos.TelaPrincipalProdutos

class formlogin : AppCompatActivity() {

    lateinit var binding: ActivityFormloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        setTheme(R.style.Theme_Main)
        binding = ActivityFormloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTeladecadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
        //extrtutura completa do meu Botao e resultados das mensagem
        binding.btEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(it,
                    "Por favor coloque email e Password! Para Logar !",
                    Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { tarefa ->
                        if (tarefa.isSuccessful) {
                            val intent = Intent(this, TelaPrincipalProdutos::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
            }
        }
    }
}