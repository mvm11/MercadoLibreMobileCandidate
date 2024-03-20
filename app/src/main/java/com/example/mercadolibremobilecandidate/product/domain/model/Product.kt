package com.example.mercadolibremobilecandidate.product.domain.model

data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val pictures: List<String>,
    val acceptsMercadoPago: Boolean,
    val freeShipping: Boolean,
)
