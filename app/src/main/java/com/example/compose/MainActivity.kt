package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.LightRed
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Margin is not available in compose instead use offset() or Spacer
         */
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = 1f)
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            ) {
                ImageCard(
                    painter = painterResource(id = R.drawable.a),
                    description = "My Launcher Image",
                    title = "My Launcher Image"
                )

                RandomColorBox(
                    Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Card == card view.
 * Box == relative layout we can put views in top of another view.
 * In this we have a stack of image, gradient color and text.
 */
@Composable
fun ImageCard(
    painter: Painter,
    description: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun CustomText() {
    val fontFamily = FontFamily(
        Font(R.font.kalam_light, FontWeight.Light),
        Font(R.font.kalam_regular, FontWeight.Medium),
        Font(R.font.kalam_bold, FontWeight.Bold)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontSize = 40.sp
                    )
                ) {
                    append("J") // withStyle's style
                }
                append("etpack ") // default style
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontSize = 40.sp
                    )
                ) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}

/**
 * Random color changer with clicks
 */
@Composable
fun RandomColorBox(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        val color = remember { // remember the value of the state of the last composition
            mutableStateOf(Color.Blue)
        }
        ColorBox(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            color.value = it
        }
        Box(
            modifier = Modifier
                .background(color.value)
                .weight(1f)
                .fillMaxSize()
        )
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(color = Color.Blue)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(), //r
                        Random.nextFloat(), //g
                        Random.nextFloat(), //n
                        1f //alpha
                    )
                )
            }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewActivity() {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(fraction = .5f)
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .background(LightRed)
                .padding(vertical = 15.dp, horizontal = 15.dp)
        ) {
            ImageCard(
                painter = painterResource(id = R.drawable.a),
                description = "My Launcher Image",
                title = "My Launcher Image"
            )
        }
    }
}