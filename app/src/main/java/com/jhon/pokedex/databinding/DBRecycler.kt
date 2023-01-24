package com.jhon.pokedex.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jhon.domain.model.PokemonModel
import com.jhon.pokedex.main.adapter.PokemonListAdapter


@BindingAdapter("setListData")
fun RecyclerView.setItemsToRecyclerView(data: List<PokemonModel>?) {
    (adapter as? PokemonListAdapter)?.let {
        it.list = data ?: emptyList()
    }
}

