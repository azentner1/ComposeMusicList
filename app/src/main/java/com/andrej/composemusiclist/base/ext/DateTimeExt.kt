package com.andrej.composemusiclist.base.ext

import java.text.SimpleDateFormat

fun String.toNamedMonth(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd").parse(this)
    val formattedDate = SimpleDateFormat("MMM dd, yyyy")
    return formattedDate.format(formatter)
}