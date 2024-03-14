package com.hfad.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hfad.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

//НАВИГАЦИЯ
@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "firstscreen" //СТАРТОВЫЙ ЭКРАН
    ){
        //Композабл элементы
        composable("firstscreen"){
            FirstScreen {age,name->
                navController.navigate("secondscreen/$age/$name") //УКАЗЫВАЕМ НА КАКОЙ ЭКРАН ПЕРЕХОДИМ
            }
        }
        composable("secondscreen/{age}/{name}"){
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age")?.toInt() ?: 0
            SecondScreen(age,name) {
                navController.navigate("thirdscreen")
            }
        }
        composable("thirdscreen"){
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}