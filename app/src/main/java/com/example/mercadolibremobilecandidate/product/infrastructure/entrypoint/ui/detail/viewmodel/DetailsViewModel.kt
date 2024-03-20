package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolibremobilecandidate.product.app.usecase.SearchProductByIdUseCase
import com.example.mercadolibremobilecandidate.product.app.usecase.SearchProductsUseCase
import com.example.mercadolibremobilecandidate.product.domain.error.DomainError
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject
constructor(private val searchProductByIdUseCase: SearchProductByIdUseCase) : ViewModel() {

    private val _id = MutableStateFlow("")

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product.asStateFlow()

    private val _error = MutableStateFlow<DomainError?>(null)
    val error: StateFlow<DomainError?> = _error.asStateFlow()

    fun setId(id: String) {
        id.takeIf { it.isNotEmpty() && it != _id.value }?.let {
            _id.value = it
            searchProductById(it)
        }
    }

    private fun searchProductById(id: String) {
        viewModelScope.launch {
            _isLoading.value = true
            when (val result = searchProductByIdUseCase(id)) {
                is DomainResult.Success -> {
                    _product.value = result.data
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