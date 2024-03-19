package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun QueryField(configuration: Configuration, query: String, onQueryChange: (String) -> Unit) {

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            QueryFieldLandscapeView(screenWidth,
                screenHeight,
                query,
                onQueryChange)
        }
        else -> {
            QueryFieldPortraitView(screenWidth,
                screenHeight,
                query,
                onQueryChange)
        }
    }
}


@Composable
fun QueryFieldLandscapeView(screenWidth: Dp,
                             screenHeight: Dp,
                             query: String,
                             onQueryChange: (String) -> Unit) {

    Box(
        contentAlignment = Alignment.Center,
    ) {
        OutlinedTextField(
            modifier = Modifier
                .width(screenWidth * 0.4f)
                .height(screenHeight * 0.15f),
            value = query,
            onValueChange = onQueryChange,
            placeholder = { Text(text = "Samsung") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(15.dp)
        )
    }
}

@Composable
fun QueryFieldPortraitView(screenWidth: Dp,
                            screenHeight: Dp,
                            query: String,
                            onQueryChange: (String) -> Unit) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(screenWidth * 0.7f)
            .height(screenHeight * 0.07f)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = { Text(text = "Samsung") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(15.dp)
        )
    }
}

