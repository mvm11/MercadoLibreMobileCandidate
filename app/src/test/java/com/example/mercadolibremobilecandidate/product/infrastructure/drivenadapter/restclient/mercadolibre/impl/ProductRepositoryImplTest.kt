package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.impl


import com.example.mercadolibremobilecandidate.product.domain.error.ErrorFactory
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.api.MercadoLibreAPI
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response.ApiResponse
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
            Product(id = "1", title = "Motorola G6 Plus", price = 17999.0, thumbnail = "http://example.com/image1.jpg"),
            Product(id = "2", title = "Motorola G6", price = 14899.0, thumbnail = "http://example.com/image2.jpg")
        )
        `when`(mercadoLibreApi.searchProducts(query)).thenReturn(
            ApiResponse(
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

