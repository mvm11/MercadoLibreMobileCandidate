package com.example.mercadolibremobilecandidate.product.domain.model

import com.example.mercadolibremobilecandidate.product.domain.error.DomainError

sealed class DomainResult<out T> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    data class Error(val error: DomainError) : DomainResult<Nothing>()
}
