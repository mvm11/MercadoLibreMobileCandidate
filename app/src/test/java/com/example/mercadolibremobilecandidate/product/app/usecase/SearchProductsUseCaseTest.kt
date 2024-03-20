package com.example.mercadolibremobilecandidate.product.app.usecase

import com.example.mercadolibremobilecandidate.product.domain.error.DomainError
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.domain.repository.ProductRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class SearchProductsUseCaseTest {

    private lateinit var repository: ProductRepository
    private lateinit var useCase: SearchProductsUseCase

    @Before
    fun setUp() {
        repository = mock(ProductRepository::class.java)
        useCase = SearchProductsUseCase(repository)
    }

    @Test
    fun `when searchProducts is called, then it should return a list of products`() = runBlocking {
        // Arrange
        val query = "Motorola G6"
        val expectedProducts = DomainResult.Success(
            listOf(
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
                ), Product(
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
        )
        `when`(repository.searchProducts(query)).thenReturn(expectedProducts)

        // Act
        val result = useCase(query)

        // Assert
        assertEquals(expectedProducts, result)
    }
}