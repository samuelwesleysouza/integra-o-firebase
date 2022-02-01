package com.shopu.shopu.model

import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.shopu.shopu.dialog.DialogPerfilUsuario

class DB {

    fun salvarDadosUsuarios(nome: String){

        val usuarioID = FirebaseAuth.getInstance().currentUser!!.uid
        val db = FirebaseFirestore.getInstance()

        val usuarios = hashMapOf (
            "nome" to nome
                )

        val documentReference: DocumentReference = db.collection(  "Usuarios").document(usuarioID)
        documentReference.set(usuarios).addOnSuccessListener {
            Log.d(  "DB", "Sucesso ao Salvar Dados!")
        }.addOnFailureListener { erro ->
            Log.d( "DB_ERROR", "Error ao salvar os dados! ${erro.printStackTrace()}")

        }
    }

    fun  recuperarDadosUsuarioPerfil(nomeUsuario: TextView, emailUsuario: TextView){

        val usuarioId = FirebaseAuth.getInstance().currentUser!!.uid
        val email = FirebaseAuth.getInstance().currentUser!!.email
        val db = FirebaseFirestore.getInstance()

        val documentReference: DocumentReference = db.collection("suarios").document(usuarioId)
        documentReference.addSnapshotListener { documento, error ->
            if (documento != null){
                nomeUsuario.text = documento.getString("nome")
                emailUsuario.text = email

            }
        }
    }
}