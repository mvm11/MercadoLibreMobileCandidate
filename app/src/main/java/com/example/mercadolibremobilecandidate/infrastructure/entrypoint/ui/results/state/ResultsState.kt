package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.state

import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult

data class ResultsState(
    val isLoading: Boolean = false,
    val searchResult: SearchResult = SearchResult(emptyList()),
    val query: String = ""
)