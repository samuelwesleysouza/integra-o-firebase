package com.shopu.shopu.model

data class Produto (
    val foto: String? = null,//tivemos que colocar em string pq e o modelo que esta no fire base
    val nome: String? = null,
    val preco: String? = null,
        )