package com.jhon.pokedex.main

import android.annotation.SuppressLint
import android.view.View
import com.jhon.pokedex.BR
import com.jhon.pokedex.R
import com.jhon.pokedex.base.BaseFragmentWithViewModel
import com.jhon.pokedex.databinding.FragmentPrincipalBinding

class PrincipalFragment : BaseFragmentWithViewModel<FragmentPrincipalBinding, PrincipalViewModel>(PrincipalViewModel::class) {


    override val getBindingVariable: Int
        get() = BR.loginviewModel

    override val getLayoutId: Int
        get() = R.layout.fragment_principal

    @SuppressLint("SetTextI18n")
    override fun onSetSetupViews() {
        super.onSetSetupViews()
        with(viewDataBinding) {

        }
    }

    override fun onFragmentViewReady(view: View) {
        super.onFragmentViewReady(view)

    }


//    private fun showGeneralAlertTwoOption() {
//        GeneralAlertDialogTwoOption(
//            icon = R.drawable.ic_error2,
//            message = getString(R.string.alert_close_message),
//            title = getString(R.string.alert_close_title),
//            onClickConfirmAcept = { finishAffinity(requireActivity()) },
//            onClickConfirmCancel = { }
//        ).show(childFragmentManager, "GeneralAlertDialog")
//    }


}