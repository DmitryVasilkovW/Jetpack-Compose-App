package org.sound.hive.jetpack.compose.app.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Screen2(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(20) { index ->
            Text(text = "Элемент $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen2() {
    Screen2(navController = rememberNavController())
}