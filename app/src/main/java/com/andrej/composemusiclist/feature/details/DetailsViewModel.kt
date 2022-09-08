package com.andrej.composemusiclist.feature.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.feature.details.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsRepository: DetailsRepository) : ViewModel() {

    var album: Album? by mutableStateOf(null)

    fun getAlbumById(albumId: String) {
        viewModelScope.launch {
            detailsRepository.getAlbumById(albumId).collect {
                album = it
            }
        }
    }
}