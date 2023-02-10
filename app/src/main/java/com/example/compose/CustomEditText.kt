package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CustomEditText : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyEditText()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    MyEditText()
}

@Composable
fun MyEditText() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        var txtField by remember {
            mutableStateOf("")
        }
        val myColor = Color(0xFF004400)
        TextField(
            value = txtField,
            onValueChange = { txtField = it },
            label = { Text(text = "Enter your name") },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "")
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = myColor, // hint color
                focusedLabelColor = myColor, // on focus hint color
                unfocusedIndicatorColor = myColor.copy(
                    alpha = TextFieldDefaults.UnfocusedIndicatorLineOpacity
                ),
                focusedIndicatorColor = myColor, // focus underline color
                backgroundColor = myColor.copy( // Color.Transparent
                    alpha = TextFieldDefaults.BackgroundOpacity
                ),
                leadingIconColor = myColor.copy(
                    alpha = .42f //TextFieldDefaults.IconOpacity
                ),
                cursorColor = myColor,
                textColor = myColor,
            ),
            // RoundCornerShape, CutCornerShape
            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
        )
    }
}
