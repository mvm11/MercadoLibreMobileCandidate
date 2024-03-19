package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.CustomSpacer
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.Header
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search.components.QueryField
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search.components.SearchButton
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search.components.SearchTitle


@Composable
fun SearchScreen(navController: NavHostController) {

    var query by rememberSaveable { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        SearchComponent(
            modifier = Modifier.fillMaxSize(),
            query,
            onQueryChange = { query = it },
            onSearch = { navController.navigate("RESULT/$query")}
        )
    }
}

@Composable
fun SearchComponent(modifier: Modifier, query: String, onQueryChange: (String) -> Unit, onSearch: () -> Unit) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Header()
                CustomSpacer(width = screenWidth, height = screenHeight * 0.10f)
                SearchTitle(configuration)
                CustomSpacer(width = screenWidth, height = screenHeight * 0.03f)
                QueryField(configuration, query, onQueryChange)
                CustomSpacer(width = screenWidth, height = screenHeight * 0.05f)
                SearchButton(configuration, onSearch)
            }
        }
        else -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Header()
                CustomSpacer(width = screenWidth, height = screenHeight * 0.20f)
                SearchTitle(configuration)
                CustomSpacer(width = screenWidth, height = screenHeight * 0.03f)
                QueryField(configuration, query, onQueryChange)
                CustomSpacer(width = screenWidth, height = screenHeight * 0.03f)
                SearchButton(configuration, onSearch)
            }
        }
    }
}


