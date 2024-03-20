package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.impl


import com.example.mercadolibremobilecandidate.product.domain.error.ErrorFactory
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.api.MercadoLibreAPI
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response.SearchProductsResponse
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response.Paging
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class ProductRepositoryImplTest {

    private val errorFactory = mock(ErrorFactory::class.java)
    private val mercadoLibreApi = mock(MercadoLibreAPI::class.java)
    private val productRepository = ProductRepositoryImpl(mercadoLibreApi, errorFactory)

    @Test
    fun `searchProducts should return expected products list when API call is successful`() = runBlocking {
        // Arrange
        val query = "iphone"
        val expectedProducts = listOf(
            Product(
                id = "123",
                title = "Example Product",
                price = 49.99,
                thumbnail = "https://example.com/thumbnail.jpg",
                pictures = listOf(
                    "https://example.com/picture1.jpg",
                    "https://example.com/picture2.jpg",
                    "https://example.com/picture3.jpg"
                ),
                acceptsMercadoPago = true,
                freeShipping = true),
            Product(
                id = "123",
                title = "Example Product",
                price = 49.99,
                thumbnail = "https://example.com/thumbnail.jpg",
                pictures = listOf(
                    "https://example.com/picture1.jpg",
                    "https://example.com/picture2.jpg",
                    "https://example.com/picture3.jpg"
                ),
                acceptsMercadoPago = true,
                freeShipping = true
            )
        )
        `when`(mercadoLibreApi.searchProducts(query)).thenReturn(
            SearchProductsResponse(
                siteId = "MCO",
                query = query,
                paging = Paging(total = 2, offset = 0, limit = 50, primaryResults = 2),
                results = expectedProducts
            )
        )

        // Act
        val result = productRepository.searchProducts(query)

        // Assert
        assert(result is DomainResult.Success)
        assertEquals(expectedProducts, (result as DomainResult.Success).data)
    }

}

