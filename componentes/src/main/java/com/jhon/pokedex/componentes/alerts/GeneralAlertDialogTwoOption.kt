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
import com.jhon.componentes.databinding.AlertDialogTwoOptionBinding

class GeneralAlertDialogTwoOption(
    @DrawableRes private val icon: Int = R.drawable.ic_error,
    private val title: String,
    private val message: String,
    private val onClickConfirmAcept: () -> Unit,
    private val onClickConfirmCancel: () -> Unit,
    private val txtBtnAceptar: String = "",
    private val txtBtnCancelar: String = "",

    ) : DialogFragment() {

    private lateinit var binding: AlertDialogTwoOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AlertDialogTwoOptionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAcept.setOnClickListener {
            dialog?.dismiss()
            onClickConfirmAcept.invoke()

        }
        binding.btnCancelar.setOnClickListener {
        
            onClickConfirmCancel.invoke()
        }
        setupDialogValues()


    }

    fun setupDialogValues() {
        with(binding) {
            tvTitle.text = title
            tvContent.text = message
            ivIcon.setImageResource(icon)
            if (txtBtnAceptar.isNotEmpty()) btnAcept.text = txtBtnAceptar
            if (txtBtnCancelar.isNotEmpty()) btnCancelar.text = txtBtnCancelar
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


}