package com.shopu.shopu.Activities.DetalhesProduto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.shopu.shopu.R
import com.shopu.shopu.databinding.ActivityDetailProdutosBinding

class detail_produtos : AppCompatActivity() {

    lateinit var biding: ActivityDetailProdutosBinding// para inflar os produtos da lista para os detalhes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityDetailProdutosBinding.inflate(layoutInflater)
        setContentView(biding.root)

        val foto = intent.extras?.getString("foto")// para recuperar os dados no adapter tela principal para os detalhes
        val nome = intent.extras?.getString("nome")
        val preco = intent.extras?.getString("preco")

        Glide.with(this).load(foto).into(biding.fotoTenis)
        biding.nomeProduto.text = nome
        biding.preco.text = "R$ ${preco}" // fomos na activity detalhes do produto e colocamos os seguintes id para fazer a recuperacao exata
    }
}