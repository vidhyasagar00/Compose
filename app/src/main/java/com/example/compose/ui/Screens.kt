package com.example.compose.ui

sealed class Screens(val route: String) {
    object EditText_Button_SnackBar : Screens("main_screen")
    object MeditationUi : Screens("detail_screen")

    fun withArgs(vararg args: String): String = buildString {
        append(route)
        args.forEach {
            append("/$it")
        }
    }
}