package com.andrej.composemusiclist.feature.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.andrej.composemusiclist.base.model.data.UiDataState
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.base.viewmodel.BaseViewModel
import com.andrej.composemusiclist.feature.home.model.HomeDataModel
import com.andrej.composemusiclist.feature.home.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel<HomeDataModel, HomeDataEvent>() {

    var homeUiDataState: UiDataState<HomeDataModel> by mutableStateOf(UiDataState.Loading)
    var albumList: List<Album> by mutableStateOf(listOf())

    init {
        observeAlbums()
    }

    override suspend fun doActionForEvent(event: HomeDataEvent) {
        when (event) {
            is HomeDataEvent.FetchMostPlayedAlbums -> {
                homeRepository.getMostPlayedAlbums().collect { data->
                    homeUiDataState = data
                }
            }
        }
    }

    private fun observeAlbums() {
        viewModelScope.launch {
            homeRepository.observeAlbums().collect {
                albumList = it
            }
        }
    }
}

sealed class HomeDataEvent {
    object FetchMostPlayedAlbums : HomeDataEvent()
}