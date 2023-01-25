package com.jhon.pokedex.data.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jhon.domain.model.PokemonModel
import com.jhon.pokedex.main.adapter.PokemonListAdapter
import com.jhon.pokedex.model.PokemonUI


@BindingAdapter("setListData")
fun RecyclerView.setItemsToRecyclerView(data: List<PokemonUI>?) {
    (adapter as? PokemonListAdapter)?.let {
        it.list = data ?: emptyList()
    }
}

