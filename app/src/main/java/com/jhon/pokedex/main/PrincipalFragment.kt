package com.jhon.pokedex.main

import com.jhon.pokedex.BR
import com.jhon.pokedex.R
import com.jhon.pokedex.base.BaseFragmentWithViewModel
import com.jhon.pokedex.databinding.FragmentPrincipalBinding
import com.jhon.pokedex.extensions.afterTextChanged
import com.jhon.pokedex.main.adapter.PokemonListAdapter
import com.jhon.pokedex.model.PokemonUI

class PrincipalFragment : BaseFragmentWithViewModel<FragmentPrincipalBinding, PrincipalViewModel>(PrincipalViewModel::class) {


    override val getBindingVariable: Int
        get() = BR.principalviewModel

    override val getLayoutId: Int
        get() = R.layout.fragment_principal

    private val adapter by lazy { PokemonListAdapter(::handleListenerAdapter) }


    override fun onSetSetupViews() {
        super.onSetSetupViews()
        with(viewDataBinding) {
            recyclerViewPokemon.adapter = adapter
        }
        myViewModel.getData()
    }

    override fun onSetupListeners() {
        super.onSetupListeners()
        with(viewDataBinding) {


            textInputLayoutPokemon.editText?.afterTextChanged {
                myViewModel.filterPokemon(it.lowercase())
            }
        }
    }


    private fun handleListenerAdapter(item: PokemonUI) {

    }


}