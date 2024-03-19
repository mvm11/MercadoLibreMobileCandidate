package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolibremobilecandidate.product.app.usecase.SearchProductsUseCase
import com.example.mercadolibremobilecandidate.product.domain.error.DomainError
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(private val searchProductsUseCase: SearchProductsUseCase) :
    ViewModel() {


    private val _query = MutableStateFlow("")

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val _error = MutableStateFlow<DomainError?>(null)
    val error: StateFlow<DomainError?> = _error.asStateFlow()


    fun setQuery(newQuery: String) {
        newQuery.takeIf { it.isNotEmpty() && it != _query.value }?.let {
            _query.value = it
            searchProducts(it)
        }
    }


    private fun searchProducts(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            when (val result = searchProductsUseCase(query)) {
                is DomainResult.Success -> {
                    _products.value = result.data
                    _isLoading.value = false
                }

                is DomainResult.Error -> {
                    _error.value = result.error
                    _isLoading.value = false
                }
            }
        }
    }
}
