package com.example.mercadolibremobilecandidate.product.app.usecase

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
        val expectedProducts = listOf(
            Product(id = "1", title = "Motorola G6 Plus", price = 17999.0, thumbnail = "http://example.com/image1.jpg"),
            Product(id = "2", title = "Motorola G6", price = 14899.0, thumbnail = "http://example.com/image2.jpg")
        )
        `when`(repository.searchProducts(query)).thenReturn(expectedProducts)

        // Act
        val result = useCase(query)

        // Assert
        assertEquals(expectedProducts, result)
    }
}