package com.shopu.shopu.formcadastro
import android.app.ProgressDialog.show
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.shopu.shopu.R
import com.shopu.shopu.databinding.ActivityFormcadastroBinding
import com.shopu.shopu.model.DB

class formcadastro : AppCompatActivity() {

    //lateinit var binding: ActivityFormcadastroBinding
     lateinit var binding: ActivityFormcadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormcadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DB()

        binding.btEntrar.setOnClickListener {
            val nome = binding.nomeCadastro.text.toString()
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val telefone = binding.TelefoneCadastro.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(it, "Preencha todos os Campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { tareffa ->
                        if (tareffa.isSuccessful) {
                            db.salvarDadosUsuarios(senha)
                            db.salvarDadosUsuarios(email)
                            val snackbar = Snackbar.make(it,
                                "Cadastro Realizado com sucesso",
                                Snackbar.LENGTH_SHORT)
                            snackbar.setBackgroundTint(Color.DKGRAY)
                            snackbar.setTextColor(Color.BLACK)
                            snackbar.show()
                        }
                    }
                }
            }
        }
    }

