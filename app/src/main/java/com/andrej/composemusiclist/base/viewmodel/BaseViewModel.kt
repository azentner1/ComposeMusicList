package com.andrej.composemusiclist.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrej.composemusiclist.base.model.data.DataResult
import com.andrej.composemusiclist.base.model.data.UiDataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<Model, Event> : ViewModel() {

    val dataStateMutableLiveData: MutableLiveData<UiDataState<Model>> = MutableLiveData()
    val dataState: LiveData<UiDataState<Model>> = dataStateMutableLiveData

    fun setStateForEvent(event: Event) {
        viewModelScope.launch {
            doActionForEvent(event)
        }
    }

    protected abstract suspend fun doActionForEvent(event: Event)

}