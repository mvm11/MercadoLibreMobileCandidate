package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolibremobilecandidate.application.product.usecase.SearchProductsUseCase
import com.example.mercadolibremobilecandidate.domain.product.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject
constructor(private val searchProductsUseCase: SearchProductsUseCase) : ViewModel() {


    private val _query = MutableStateFlow("")

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    fun setQuery(newQuery: String) {
        if (newQuery.isNotEmpty() && newQuery != _query.value) {
            _query.value = newQuery
            searchProducts(newQuery)
        }
    }

    private fun searchProducts(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = searchProductsUseCase.invoke(query)
                _products.value = result
            } catch (e: Exception) {
                // Handle the error
            } finally {
                _isLoading.value = false
            }
        }
    }
}
