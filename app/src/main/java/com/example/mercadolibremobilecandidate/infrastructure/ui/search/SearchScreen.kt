package com.example.mercadolibremobilecandidate.infrastructure.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mercadolibremobilecandidate.R
import com.example.mercadolibremobilecandidate.infrastructure.ui.navigation.Routes


@Composable
fun SearchScreen(navController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable { navController.navigate(Routes.RESULT) }
    ) {
        Text(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        text = Routes.SEARCH)

    }
}

@Preview
@Composable
fun SearchScreenPreview(){
    SearchScreen(rememberNavController())
}

@Composable
fun Search(modifier: Modifier, viewModel: SearchViewModel) {

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField("Mateo")
        Spacer(modifier = Modifier.padding(4.dp))
        LoginButton()
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
fun EmailField(email: String) {
    TextField(
        value = email, onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = true
    ) {
        Text(text = "Iniciar sesión")
    }
}

