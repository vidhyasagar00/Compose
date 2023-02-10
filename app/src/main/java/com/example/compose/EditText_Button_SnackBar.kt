package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.compose.ui.Navigation
import com.example.compose.ui.Screens
import kotlinx.coroutines.launch

class EditText_Button_SnackBar(val navController: NavController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //default scaffold state
            val scaffoldState = rememberScaffoldState()

            var txt by remember {
                mutableStateOf("")
            }

            val scope = rememberCoroutineScope()

            /**
             * Scaffold is used to use existing material design
             */
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                ) {
                    OutlinedTextField(
                        value = txt,
                        label = {
                            Text(text = "Enter your name")
                        },
                        onValueChange = {
                            txt = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Button(
                        onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hello $txt", duration = SnackbarDuration.Short)
                            }
                            navController.navigate(Screens.MeditationUi.withArgs(txt))
                        }
                    ) {
                        Text(text = "Show SnackBar")
                    }
                }
            }
        }
    }
}