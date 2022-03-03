package com.shopu.shopu.model
import android.util.Log
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.shopu.shopu.Adapter.AdapterProduto

class DB {
    fun salvarDadosUsuarios(nome: String) {
        val usuarioID = FirebaseAuth.getInstance().currentUser!!.uid
        val db = FirebaseFirestore.getInstance()

        val usuarios = hashMapOf(
            "nome" to nome
        )
        val documentReference: DocumentReference = db.collection("Usuario").document(usuarioID)
        documentReference.set(usuarios).addOnSuccessListener {
            Log.d("DB", "Sucesso ao Salvar Dados!")
        }.addOnFailureListener { erro ->
            Log.d("DB_ERROR", "Error ao salvar os dados! ${erro.printStackTrace()}")
        }
    }
    fun reucuperarDadosUsuarioPerfil(nomeUsuario: TextView, emailUsuario: TextView){

        val usuarioId = FirebaseAuth.getInstance().currentUser!!.uid
        val email = FirebaseAuth.getInstance().currentUser!!.email
        val db = FirebaseFirestore.getInstance()
        val documentReference: DocumentReference = db.collection("Usuario").document(usuarioId)
        documentReference.addSnapshotListener { documento, error ->
            if (documento != null) {
                nomeUsuario.text = documento.getString("nome")
                emailUsuario.text = email
            }
        }
    }

    fun obterListaDeProdutos(lista_produtos: MutableList<Produto>, adapter_produto: AdapterProduto){

        val db = FirebaseFirestore.getInstance()// Base inteira para buscar a lista que criamos no Banco de dados dos Produtos e preço nomes
        db.collection("Produtos").get()
            .addOnCompleteListener { tarefa ->
                if (tarefa.isSuccessful){
                    for (documento in tarefa.result!!) {
                    val produto = documento.toObject(Produto::class.java)
                        lista_produtos.add(produto)
                        adapter_produto.notifyDataSetChanged()//Apos ir para tela de Produtos para criar a variavel db do banco de dados
                   }
                }
            }
        }
    }








