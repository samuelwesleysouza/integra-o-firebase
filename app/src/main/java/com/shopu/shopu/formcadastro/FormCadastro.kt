package com.shopu.shopu.formcadastro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.shopu.shopu.R
import com.shopu.shopu.databinding.ActivityFormcadastroBinding
import com.shopu.shopu.model.DB

class FormCadastro : AppCompatActivity() {

    //lateinit var binding: ActivityFormcadastroBinding
    lateinit var binding: ActivityFormcadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormcadastroBinding.inflate(layoutInflater)

        val db = DB()

        binding.btCadastrar.setOnClickListener {

            val nome = binding.nomeCadastro.text.toString()
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(it, "Preencha todos os Campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { tareffa ->
                        if (tareffa.isSuccessful) {
                            db.salvarDadosUsuarios(nome)
                            db.salvarDadosUsuarios(senha)
                            db.salvarDadosUsuarios(email)
                            val snackbar = Snackbar.make(it,
                                "Cadastro Realizado com sucesso", Snackbar.LENGTH_SHORT)
                            snackbar.setBackgroundTint(Color.DKGRAY)
                            snackbar.setTextColor(Color.BLACK)
                            snackbar.show()
                        }
                    }.addOnFailureListener { erroCadastro ->

                        val mensagemErro = when (erroCadastro) {
                            is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres"
                            is FirebaseAuthUserCollisionException -> "Está conta já foi cadastrada"
                            is FirebaseNetworkException -> "Sem conexão com a Internet"
                            else -> "Erro ao cadastrar usuário"
                        }
                        val snackbar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.setTextColor(Color.WHITE)
                        snackbar.show()

                    }
            }
        }
    }
}


