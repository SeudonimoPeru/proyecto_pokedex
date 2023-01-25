package com.jhon.data

import java.util.*

fun String.uppercaseFirstLetter(): String {
   return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}