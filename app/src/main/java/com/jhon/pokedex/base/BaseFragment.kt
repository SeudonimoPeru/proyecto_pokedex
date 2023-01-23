package com.jhon.pokedex.base

import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.jhon.pokedex.componentes.loading.Loading
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment() {


    private var loadingDialog = Loading()

    private var isLoadingShow: Boolean = false


    //region SnackBar
    protected fun showSnackBar(
        rootView: View,
        contentText: Any?,
        duration: Int = Snackbar.LENGTH_LONG
    ) {
        val text = when (contentText) {
            is String -> contentText
            is Int -> getString(contentText)
            else -> ""
        }
        Snackbar.make(rootView, text, duration).show()
    }

    //endregion

    //region Loading Dialog Fragment
    protected fun showLoading(showLoading: Boolean, messageToShow: Any? = null) {
        if (showLoading && !isLoadingShow) {
            showLoadingDialog()
        } else {
            closeLoadingDialog()
        }
    }


    private fun getDynamicMessage(messageToShow: Any?): String? {
        return if (messageToShow != null) {
            when (messageToShow) {
                is Int -> {
                    getString(messageToShow)
                }
                is String -> {
                    messageToShow
                }
                else -> {
                    null
                }
            }
        } else {
            messageToShow
        }
    }

    private fun showLoadingDialog() {
        removeLoadingDialogFromBackStack()
        if (activity != null) {
            if (!loadingDialog.isVisible) {
                loadingDialog.show(childFragmentManager, "loadingDialog")
            }
        }
    }


    private fun closeLoadingDialog() {
        loadingDialog.dismiss()
        isLoadingShow = false
    }


    private fun removeLoadingDialogFromBackStack() {
        if (activity != null) {
            val oldLoadingDialog = childFragmentManager.findFragmentByTag("loadingDialog")
            if (oldLoadingDialog != null) {
                if (!oldLoadingDialog.isVisible) {
                    childFragmentManager.beginTransaction()
                        .remove(oldLoadingDialog)
                        .addToBackStack(null)
                    isLoadingShow = false
                }
            }
        }
    }


    private fun removeErrorDialogFromBackStack() {
        if (activity != null) {
            val oldErrorDialog: DialogFragment? =
                childFragmentManager.findFragmentByTag("ErrorDialog") as DialogFragment?
            if (oldErrorDialog != null) {
                if (!oldErrorDialog.isVisible) {
                    childFragmentManager.beginTransaction()
                        .remove(oldErrorDialog)
                        .addToBackStack(null)
                } else {
                    oldErrorDialog.dismiss()
                    childFragmentManager.beginTransaction()
                        .remove(oldErrorDialog)
                        .addToBackStack(null)
                }
            }
        }
    }
    //endregion

    protected fun showToast(message: Any?) {
        val textToShow = when (message) {
            is Int -> getString(message)
            is String -> message
            else -> {
                ""
            }
        }
        Toast.makeText(requireContext(), textToShow, Toast.LENGTH_LONG).show()
    }


}