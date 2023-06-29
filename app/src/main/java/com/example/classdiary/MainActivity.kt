package com.example.classdiary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.classdiary.screen.ScreenListOfStudents
import com.example.classdiary.screen.ScreenLogin
import com.example.classdiary.ui.theme.ClassDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassDiaryTheme {
                    AppClassDiary()
                }
            }
        }
    }

@Composable
fun AppClassDiary(){

    val navigationControl = rememberNavController()

    NavHost(
        navController = navigationControl,
        startDestination = "Login"){

        composable(
            route = "Login"
        ){
            ScreenLogin(navigationControl)
        }

        composable(
            route = "ListOfStudents"
        ) {
            ScreenListOfStudents(navigationControl)
        }
    }
}