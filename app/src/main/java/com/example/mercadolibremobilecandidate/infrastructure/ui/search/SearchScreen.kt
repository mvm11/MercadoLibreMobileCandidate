package com.example.mercadolibremobilecandidate.infrastructure.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mercadolibremobilecandidate.R


@Composable
fun SearchScreen(navController: NavHostController) {

    var query by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Search(
            modifier = Modifier.fillMaxSize(),
            query,
            onQueryChange = { query = it },
            onSearch = { navController.navigate("RESULT/$query")}
        )
    }
}

@Composable
fun Search(modifier: Modifier, query: String, onQueryChange: (String) -> Unit, onSearch: () -> Unit) {
    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        QueryField(query, onQueryChange)
        Spacer(modifier = Modifier.padding(4.dp))
        SearchButton(onSearch)
    }
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.header_image),
        contentDescription = "Header",
        modifier = modifier
    )
}

@Composable
fun QueryField(query: String, onQueryChange: (String) -> Unit) {


    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Buscar en Mercado Libre") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun SearchButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = true
    ) {
        Text(text = "Buscar")
    }
}
