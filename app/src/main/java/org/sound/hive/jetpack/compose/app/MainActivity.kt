package org.sound.hive.jetpack.compose.app

import Screen1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sound.hive.jetpack.compose.app.ui.screen.Screen2
import org.sound.hive.jetpack.compose.app.ui.screen.Screen3
import org.sound.hive.jetpack.compose.app.ui.screen.Screen4
import org.sound.hive.jetpack.compose.app.ui.screen.Screen5

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Screen1") },
                    label = { Text("Screen1") },
                    selected = false,
                    onClick = { navController.navigate("screen1") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Screen2") },
                    label = { Text("Screen2") },
                    selected = false,
                    onClick = { navController.navigate("screen2") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "screen1",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("screen1") { Screen1(navController) }
            composable("screen2") { Screen2(navController) }
            composable("screen3") { Screen3(navController) }
            composable("screen4") { Screen4(navController) }
            composable("screen5") { Screen5(navController) }
        }
    }
}
