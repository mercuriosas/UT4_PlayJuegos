package com.example.ut4_playjuegosv2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ut4_playjuegosv2.ui.theme.TemaPersonalizado
import com.example.ut4_playjuegosv2.ui.theme.UT4_PlayJuegosV2Theme
import com.example.ut4_playjuegosv2.ui.theme.courgetteRegularFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemaPersonalizado{
            //UT4_PlayJuegosV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//MenuPlayJuegos()
                    //MenuNewPlayer()
                    //preferences()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "PlayJuegos") {

                        composable("PlayJuegos") { MenuPlayJuegos(navController) }

                        composable("Play") { Games() }
                        composable("NewPlayer") { MenuNewPlayer() }
                        composable("Preferences") { preferences() }
                        composable("About") { UsersView() }
                        composable("Tipos") { Types() }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MenuPlayJuegos(navController: NavHostController) {
    //Variable para la rotación de la pantalla
    val configuration = LocalConfiguration.current
    //var corutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.rasengan),
                contentDescription = "Rasengan", Modifier.size(150.dp)
            )
            Text(
                "Play Juegos", style = TextStyle(
                    fontSize = 50.sp,
                    fontFamily = courgetteRegularFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    Button(
                        onClick = {navController.navigate("Play") },
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(text = "Play")
                    }
                    //Spacer(modifier = Modifier.size(20.dp))
                    Button(
                        onClick = {navController.navigate("Preferences") },
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(text = "Preferences")
                    }
                    Button(
                        onClick = {navController.navigate("NewPlayer") },
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(text = "New Player")
                    }
                    //Spacer(modifier = Modifier.size(20.dp))
                    //Button(onClick = { navController.navigate("Preferences") }, modifier = Modifier.width(200.dp)) {
                    Button(
                        onClick = {navController.navigate("About") },
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(text = "About")
                    }
                    Button(
                        onClick = { navController.navigate("Tipos")},
                        modifier = Modifier.width(200.dp)
                    ) {
                        Text(text = "Types")
                    }
                }
                else -> {
                    Row(){
                        Button(
                            onClick = {navController.navigate("Play") },
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "Play")
                        }

                        //Spacer(modifier = Modifier.size(20.dp))
                        Button(
                            onClick = { navController.navigate("Preferences")},
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "Preferences")
                        }
                    }
                    Row(){
                        Button(
                            onClick = { navController.navigate("NewPlayer")},
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "New Player")
                        }
                        //Spacer(modifier = Modifier.size(20.dp))
                        //Button(onClick = { navController.navigate("Preferences") }, modifier = Modifier.width(200.dp)) {
                        Button(
                            onClick = {navController.navigate("About") },
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "About")
                        }
                    }
                    Row(horizontalArrangement = Arrangement.Center) {
                        Button(
                            onClick = { navController.navigate("Types")},
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "Types")
                        }
                    }
                }
            }
        }
    }
}
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Recibe una función lambda que recibe una String (ponemos ->unit para indicar que es una función)
fun MyTopAppBar() {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = "TopAppBar") },
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            //Llamada a la función de click definida en Scaffold
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Back")
            }
        },
        actions = {
            //Llamada a la función de click definida en Scaffold
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }
            //Llamada a la función de click definida en Scaffold
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorito")
            }
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menú")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir")
                    Text(text = "Compartir")
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock")
                    Text(text = "Album")
                }
            }
        }
    )
}

 */