package com.jhon.pokedex.main

import android.view.View
import com.jhon.domain.model.PokemonModel
import com.jhon.pokedex.BR
import com.jhon.pokedex.R
import com.jhon.pokedex.base.BaseFragmentWithViewModel
import com.jhon.pokedex.databinding.FragmentPrincipalBinding
import com.jhon.pokedex.main.adapter.PokemonListAdapter

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

    override fun onFragmentViewReady(view: View) {
        super.onFragmentViewReady(view)

    }


    private fun handleListenerAdapter(item: PokemonModel) {

    }


}