package com.jhon.pokedex.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhon.pokedex.R
import com.jhon.pokedex.databinding.ItemPokemonBinding
import com.jhon.pokedex.extensions.basicDiffUtil
import com.jhon.pokedex.extensions.bindingInflate
import com.jhon.pokedex.model.PokemonUI

class PokemonListAdapter(private val listener: (PokemonUI) -> Unit) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    var list: List<PokemonUI> by basicDiffUtil(
        emptyList(), { old, new -> old.name == new.name }
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(parent.bindingInflate(R.layout.item_pokemon, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.dataBinding.item = item
        holder.dataBinding.textNamePokemon.setOnClickListener {
            listener.invoke(item)
        }

    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val dataBinding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(dataBinding.root)
}