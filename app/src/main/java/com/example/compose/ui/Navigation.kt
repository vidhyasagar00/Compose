package com.example.compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose.EditText_Button_SnackBar
import com.example.compose.MeditationUi

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.EditText_Button_SnackBar.route) {
        composable(route = Screens.EditText_Button_SnackBar.route) {
            EditText_Button_SnackBar(navController = navController)
        }
        composable(
            route = Screens.MeditationUi.route + "/{name}", // use this for non nullable and for nullable use "?name={name}"
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "vidhyasagar"
                    nullable = true
                }
            )
        ) {
            MeditationUi(name = it.arguments?.getString("name"))
        }
    }
}