package org.sound.hive.jetpack.compose.app.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Screen3(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (title, button) = createRefs()
        Text(
            text = "Экран с ConstraintLayout",
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Button(
            onClick = { navController.navigate("screen4") },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(title.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Далее")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen3() {
    Screen3(navController = rememberNavController())
}
