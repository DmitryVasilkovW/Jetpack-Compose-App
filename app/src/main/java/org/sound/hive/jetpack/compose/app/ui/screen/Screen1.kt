import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.sound.hive.jetpack.compose.app.R

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


@Preview(showBackground = true)
@Composable
fun PreviewScreen1() {
    Screen1(navController = rememberNavController())
}