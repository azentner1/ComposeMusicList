package com.andrej.composemusiclist.feature.home

import com.andrej.composemusiclist.base.model.data.DataResult
import com.andrej.composemusiclist.base.viewmodel.BaseViewModel
import com.andrej.composemusiclist.feature.home.model.HomeDataModel
import com.andrej.composemusiclist.feature.home.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel<HomeDataModel, HomeDataEvent>() {

    override suspend fun doActionForEvent(event: HomeDataEvent) {
        when (event) {
            is HomeDataEvent.FetchMostPlayedAlbums -> {
                homeRepository.getMostPlayedAlbums().collect { data->
                    dataStateMutableLiveData.value = data
                }
            }
        }
    }
}

sealed class HomeDataEvent {
    object FetchMostPlayedAlbums : HomeDataEvent()
}