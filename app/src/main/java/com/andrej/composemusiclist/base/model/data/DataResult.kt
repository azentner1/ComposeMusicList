package com.andrej.composemusiclist.base.model.data

/**
 * Data result class
 */

sealed class DataResult<out T> {

    data class Success<out T>(val data: T) : DataResult<T>()

    data class Error(val error: ErrorEntity) : DataResult<Nothing>()

}