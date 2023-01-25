package com.jhon.pokedex.componentes.alerts

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

class GeneralAlertDialog(
    @DrawableRes private val icon: Int = R.drawable.ic_error,
    private val title: String,
    private val message: String,

    ) : DialogFragment() {

    private lateinit var binding: AlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = AlertDialogBinding.inflate(inflater, container, false)
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
            tvTitle.text = title
            tvContent.text = message
            ivIcon.setImageResource(icon)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


}