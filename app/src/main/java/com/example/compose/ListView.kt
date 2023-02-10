package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ListView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnWithList(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun NormalColumn(modifier: Modifier) {
    //used for scroll to particular position
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..50)
            Text(
                text = "Item $i",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
    }
}

/**
 * LazyColumn creates column when we scroll to the position.
 * In normal column all items are loaded when activity created.
 */
@Composable
fun CustomLazyColumn(modifier: Modifier) {
    LazyColumn {
        items(count = 500) {
            Text(
                text = "Item ${it + 1}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(vertical = 24.dp)
            )
        }
    }
}

@Composable
fun LazyColumnWithList(modifier: Modifier) {
    LazyColumn {
        itemsIndexed(
            listOf(3, 45, 53, 6, 56, 334, 24234, 234, 234, 2, 42, 32, 25, 6, 16, 7, 5, 8, 9, 55454, 6)
        ) { index, item ->
            Text(
                text = "Item in $index is $item",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(vertical = 24.dp)
            )
        }
    }
}
