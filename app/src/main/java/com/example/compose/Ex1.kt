package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.GradientButton

class Ex1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginView()
        }
    }
}

@Composable
fun LoginView() {
    var mobileNumber by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    val transparentColor = Color.Transparent
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "back",
                    modifier = Modifier.size(25.dp)
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    text = "LOGIN",
                    style = MaterialTheme.typography.h1
                )
            }
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.Cyan)
                            .padding(25.dp)
                    ) {
                        Column {
                            Text(text = "Mobile Number")
                            TextField(value = mobileNumber, onValueChange = {
                                mobileNumber = it
                            }, leadingIcon = {
                                Icon(painter = painterResource(id = R.drawable.phone), contentDescription = "")
                            }, colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = transparentColor,
                                focusedLabelColor = transparentColor,
                                unfocusedIndicatorColor = Color.Black,
                                focusedIndicatorColor = Color.Black,
                                backgroundColor = transparentColor,
                                leadingIconColor = Color.Black,
                                cursorColor = Color.Black,
                                textColor = Color.Black,
                            )
                            )
                            Text(text = "Password")
                            TextField(value = password, onValueChange = {
                                password = it
                            }, leadingIcon = {
                                Icon(painter = painterResource(id = R.drawable.lock), contentDescription = "")
                            }, colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = transparentColor,
                                focusedLabelColor = transparentColor,
                                unfocusedIndicatorColor = Color.Black,
                                focusedIndicatorColor = Color.Black,
                                backgroundColor = transparentColor,
                                leadingIconColor = Color.Black,
                                cursorColor = Color.Black,
                                textColor = Color.Black,
                            )
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = rememberMe,
                                    onCheckedChange = {
                                        rememberMe = it
                                    }
                                )
                                Text(
                                    text = "Remember Me",
                                    style = MaterialTheme.typography.body1,
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 45.dp),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Button(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .background(
                                            brush = Brush.horizontalGradient(
                                                listOf(Color.Blue, Color.Red)
                                            ),
                                            shape = RoundedCornerShape(20.dp)
                                        ),
                                    shape = RoundedCornerShape(20.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color.Transparent,
                                        contentColor = Color.White
                                    ),
                                    onClick = {
                                        /*TODO*/
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.arrow_next), contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 35.dp)
                            .fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 15.dp),
                                text = "Don't have an account?",
                                style = MaterialTheme.typography.body1,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                            GradientButton(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Sign Up",
                                onClick = { /*TODO*/ },
                                startColor = Color.Blue,
                                endColor = Color.Red
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun LoginPreview() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        LoginView()
    }
}