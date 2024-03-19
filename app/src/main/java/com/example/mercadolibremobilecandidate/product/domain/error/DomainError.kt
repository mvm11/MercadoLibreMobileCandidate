package com.example.mercadolibremobilecandidate.product.domain.error

sealed interface DomainError {
    fun getMessage(): String
}

data object NoInternetError : DomainError {
    override fun getMessage(): String {
        return "No tienes acceso a internet o no estás conectado a internet"
    }
}

data object UnexpectedError : DomainError {
    override fun getMessage(): String {
        return "Error inesperado. Intenta más tarde"
    }
}




