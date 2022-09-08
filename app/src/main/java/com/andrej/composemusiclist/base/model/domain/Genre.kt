package com.andrej.composemusiclist.base.model.domain

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("genreId") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
