package com.andrej.composemusiclist.base.model.data

abstract class ErrorEntity {

    object Network : ErrorEntity()

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object Unknown : ErrorEntity()

    object Logout : ErrorEntity()
}