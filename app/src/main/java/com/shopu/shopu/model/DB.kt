package com.shopu.shopu.model

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

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

}