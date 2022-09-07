package com.andrej.composemusiclist.feature.home.model

import com.andrej.composemusiclist.base.model.domain.Album
import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("feed") val feed: FeedResponse
)

data class FeedResponse(
    @SerializedName("results") val results: List<Album>
)