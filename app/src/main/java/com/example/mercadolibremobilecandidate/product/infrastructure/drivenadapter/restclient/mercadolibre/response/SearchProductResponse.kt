package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response

data class SearchProductResponse(
    val id: String,
    val siteId: String,
    val title: String,
    val sellerId: Long,
    val categoryId: String,
    val price: Double,
    val currencyId: String,
    val thumbnail: String,
    val pictures: List<Picture>,
    val acceptsMercadoPago: Boolean,
    val shipping: Shipping
)

data class Picture(
    val id: String,
    val url: String,
    val secureUrl: String,
    val size: String,
    val maxSize: String,
    val quality: String
)

data class Shipping(
    val mode: String,
    val freeShipping: Boolean,
    val logisticType: String
)
