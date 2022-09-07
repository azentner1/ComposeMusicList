package com.andrej.composemusiclist.feature.home.api

import com.andrej.composemusiclist.feature.home.model.HomeResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeApiService {

    @GET("/api/v2/us/music/most-played/100/albums.json")
    fun fetchMostPlayedAlbums(): Call<HomeResponse>
}