package com.shopu.shopu.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import com.shopu.shopu.databinding.DialogPerfilUsuarioBinding
import com.shopu.shopu.formloguim.FormLogin
import com.shopu.shopu.model.DB

class DialogPerfilUsuario(private val activity: Activity) {

    lateinit var dialog: AlertDialog
    lateinit var binding: DialogPerfilUsuarioBinding




    fun  iniciarPerfilUsuario() {
        val builder = AlertDialog.Builder(activity)
        binding = DialogPerfilUsuarioBinding.inflate(activity.layoutInflater)
        builder.setView(binding.root)
        builder.setCancelable(true)
        dialog = builder.create()
        dialog.show()
    }

    fun recuperarDadosUsuariosBanco() {
        val nomeUsuario = binding.txtNomeUsuario
        val emailUsuario = binding.txtEmailusuario
        val db = DB()
        db.recuperarDadosUsuarioPerfil(nomeUsuario,emailUsuario)

        binding.btDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
        val intent = Intent(activity,FormLogin::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    }
}
