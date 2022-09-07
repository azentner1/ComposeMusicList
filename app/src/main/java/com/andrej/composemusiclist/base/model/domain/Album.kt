package com.andrej.composemusiclist.base.model.domain

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("artistName") val artistName: String,
    @SerializedName("artworkUrl100") val artworkUrl: String
)