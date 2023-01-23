package com.jhon.pokedex.componentes.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.jhon.componentes.R

class Loading : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //en este caso para hacerlo full transparent
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog_full_transparent);
        isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_loading, container, false)
    }


}