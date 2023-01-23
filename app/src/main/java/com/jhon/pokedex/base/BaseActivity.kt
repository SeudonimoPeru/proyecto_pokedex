package com.jhon.pokedex.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.jhon.pokedex.componentes.loading.Loading
import com.jhon.pokedex.R
import org.koin.android.compat.ViewModelCompat.viewModel

import kotlin.reflect.KClass

abstract class BaseActivity<ViewDataBindingClass : ViewDataBinding, out ViewModel : BaseViewModel>(
    clazz: KClass<ViewModel>
) : AppCompatActivity() {

    private var loadingDialog = Loading()

    lateinit var viewDataBinding: ViewDataBindingClass

    val myViewModel: ViewModel by viewModel(this, clazz.java)


    abstract val getLayoutId: Int

    abstract val getBindingVariable: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_PTER)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId)
        viewDataBinding.setVariable(getBindingVariable, myViewModel)
        /**
         * use Fragment.viewLifecycleOwner for fragments
         */
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.executePendingBindings()

        onActivityReady()
    }

    open fun onActivityReady() {

    }

    //region Loading Dialog Fragment
    protected fun showLoading(showLoading: Boolean) {
        if (showLoading) {
            showLoadingDialog()
        } else {
            closeLoadingDialog()
        }
    }


    private fun showLoadingDialog() {
        removeLoadingDialogFromBackStack()
        if (!loadingDialog.isVisible) {
            loadingDialog.show(supportFragmentManager, "loadingDialog")
        }
    }


    private fun closeLoadingDialog() {
        loadingDialog.dismiss()
    }


    private fun removeLoadingDialogFromBackStack() {
        val oldLoadingDialog = supportFragmentManager.findFragmentByTag("loadingDialog")
        if (oldLoadingDialog != null) {
            if (!oldLoadingDialog.isVisible) {
                supportFragmentManager.beginTransaction()
                    .remove(oldLoadingDialog)
                    .addToBackStack(null)
            }
        }
    }

    protected fun showToast(message: Any?) {
        val textToShow = when (message) {
            is Int -> getString(message)
            is String -> message
            else -> {
                ""
            }
        }
        Toast.makeText(this, textToShow, Toast.LENGTH_LONG).show()
    }
    //endregion

}