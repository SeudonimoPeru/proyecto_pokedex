package com.jhon.pokedex.extensions

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("setGlideImageUri")
fun setGlideImageUri(
    view: AppCompatImageView,
    imageUri: String?
) {
    if (!imageUri.isNullOrEmpty()) {
        view.layout(0, 0, 0, 0)
        Glide.with(view.context)
            .load(imageUri)
            .fitCenter()
            .into(view)
    }
}
