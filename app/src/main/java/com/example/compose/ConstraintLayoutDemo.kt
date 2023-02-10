package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


/**
 * add dependency for constraint layout
 */
class ConstraintLayoutDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                val blueBox = createRefFor("blueBox")
                val blackBox1 = createRefFor("blackBox1")
                val blackBox2 = createRefFor("blackBox2")

                val guideline = createGuidelineFromTop(.5f)

                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints // = set width to 0dp in ConstraintLayout
                    height = Dimension.value(50.dp)
                }

                constrain(redBox) {
                    top.linkTo(greenBox.bottom)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(blueBox) {
                    start.linkTo(redBox.end)
                    top.linkTo(redBox.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(100.dp)
                }

                constrain(blackBox1) {
                    top.linkTo(guideline)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(blackBox2) {
                    top.linkTo(guideline)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }


                createHorizontalChain(
                    blackBox1,
                    blackBox2,
                    chainStyle = ChainStyle.Packed)
            }

            ConstraintLayout(
                constraintSet = constraints,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenBox")
                )

                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redBox")
                )

                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .layoutId("blueBox")
                )

                Box(
                    modifier = Modifier
                        .background(Color.Black)
                        .layoutId("blackBox1")
                )

                Box(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .layoutId("blackBox2")
                )
            }
        }
    }
}