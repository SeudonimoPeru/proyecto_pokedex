package com.jhon.pokedex.main.dialogdetalle

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.DialogFragment
import com.jhon.componentes.R

import com.jhon.componentes.databinding.AlertDialogBinding
import com.jhon.domain.model.PokemonDetalleModel
import com.jhon.pokedex.databinding.DialogPokemonDetalleBinding

class DetallelAlertDialog(
    private val pokemonDetalleModel: PokemonDetalleModel,
) : DialogFragment() {

    private lateinit var binding: DialogPokemonDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DialogPokemonDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {
            dialog?.dismiss()

        }
        setupDialogValues()


    }

    private fun setupDialogValues() {
        with(binding) {
            tvnamePokemon.text = pokemonDetalleModel.name
            tvability.text = pokemonDetalleModel.firstPower
            tvtype.text = pokemonDetalleModel.type

        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


}