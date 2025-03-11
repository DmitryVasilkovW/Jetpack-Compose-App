package org.sound.hive.jetpack.compose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

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

@Composable
fun Screen1(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Добро пожаловать!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Логотип",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Введите текст") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("screen2") }) {
            Icon(Icons.Default.ArrowForward, contentDescription = "Далее")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Перейти на следующий экран")
        }
    }
}

// Экран 2: Использование LazyColumn для списка
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

// Экран 3: Использование ConstraintLayout
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

@Composable
fun Screen4(navController: NavController) {
    var count by remember { mutableStateOf(0) }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen5(navController: NavController) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ModalBottomSheet(
            onDismissRequest = {},
            sheetState = sheetState
        ) {
            Text("Это Bottom Sheet", modifier = Modifier.padding(16.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { coroutineScope.launch { sheetState.show() } }) {
            Text("Показать Bottom Sheet")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen1() {
    Screen1(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen2() {
    Screen2(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen3() {
    Screen3(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen4() {
    Screen4(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen5() {
    Screen5(navController = rememberNavController())
}
