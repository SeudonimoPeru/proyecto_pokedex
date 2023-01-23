package com.jhon.pokedex.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

// channge format
fun String.convertToDateWithFormat(currentFormat: String, expectedFormat: String): String {
    if (this.isNotEmpty()) {
        val format = SimpleDateFormat(currentFormat, Locale.ROOT)
        return try {
            val date = format.parse(this)
            val simpleDateFormat = SimpleDateFormat(expectedFormat, Locale.ROOT)
            simpleDateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            ""
        }
    }
    return ""
}