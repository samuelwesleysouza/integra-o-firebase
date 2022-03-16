package com.shopu.shopu.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopu.shopu.Activities.DetalhesProduto.Detail_produtos
import com.shopu.shopu.databinding.ProdutoItemBinding
import com.shopu.shopu.model.Produto

class AdapterProduto(val context: Context, val lista_produtos: MutableList<Produto>):
    RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val item_lista = ProdutoItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return ProdutoViewHolder(item_lista)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        Glide.with(context).load(lista_produtos.get(position).foto).into(holder.fotoProduto)
        holder.nomeProduto.text = lista_produtos.get(position).nome
        holder.precoProduto.text = " R$ ${lista_produtos.get(position).preco}" //essa concatenização e para mostrar os $ dos valores dos produtos

       holder.itemView.setOnClickListener {
           val intent = Intent(context, Detail_produtos::class.java)// Nossa intenção de ir da lista de produtos para tela de detalhe de protudo
           intent.putExtra("foto",lista_produtos.get(position).foto)
           intent.putExtra("nome",lista_produtos.get(position).nome)
           intent.putExtra("preco",lista_produtos.get(position).preco)
           context.startActivity(intent)  // tivemos que colocar nessa intencao o context para ele ir de item a item para os detalhes caso nao tenha vc vai para a pg
       }
    }

    override fun getItemCount() = lista_produtos.size

    inner class ProdutoViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root){
        val fotoProduto = binding.fotoProduto
        val nomeProduto = binding.nomeProduto
        val precoProduto = binding.precoProduto

    }
}
