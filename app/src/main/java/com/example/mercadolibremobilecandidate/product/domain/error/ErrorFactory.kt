package com.example.mercadolibremobilecandidate.product.domain.error

import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorFactory @Inject constructor() {
    fun getError(error: Throwable): DomainError {
        return when (error) {
            is UnknownHostException -> NoInternetError
            else -> UnexpectedError
        }
    }
}