package org.sound.hive.jetpack.compose.app.ui.screen

//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Screen4(navController: NavController) {
    var count by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Счетчик: $count", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text("Увеличить")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen4() {
    Screen4(navController = rememberNavController())
}
