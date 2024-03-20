package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.impl

import com.example.mercadolibremobilecandidate.product.domain.error.ErrorFactory
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.domain.repository.ProductRepository
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.api.MercadoLibreAPI
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response.SearchProductResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val mercadoLibreAPI: MercadoLibreAPI,
    private val errorFactory: ErrorFactory
) : ProductRepository {
    override suspend fun searchProducts(query: String): DomainResult<List<Product>> {
        return try {
            val response = mercadoLibreAPI.searchProducts(query)
            DomainResult.Success(response.results)
        } catch (exception: Exception) {
            DomainResult.Error(errorFactory.getError(exception))
        }
    }

    override suspend fun searchProductById(id: String): DomainResult<Product> {
        return try {
            val response = mercadoLibreAPI.searchProductById(id)
            val pictures: List<String> = response.pictures.map { picture -> picture.url}
            val product = getProduct(response, pictures)

            DomainResult.Success(product)
        } catch (exception: Exception) {
            DomainResult.Error(errorFactory.getError(exception))
        }
    }

    private fun getProduct(response: SearchProductResponse, pictures: List<String>): Product {
        return Product(response.id,
            response.title,
            response.price,
            response.thumbnail,
            pictures,
            response.acceptsMercadoPago,
            response.shipping.freeShipping)
    }
}

