package com.gfdellatin.happybirthday

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DigitalLemonadeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitalLemonadeApp()
        }
    }
}

@Composable
fun DigitalLemonade(
    stringResource: Int,
    drawable: Int,
    contentDescription: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = stringResource))
        Spacer(modifier = Modifier.height(16.dp))

        Surface(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, color = Color.Green)
        ) {
            Image(
                painterResource(id = drawable),
                contentDescription = stringResource(id = contentDescription),
                modifier = Modifier
                    .clickable(
                        onClick = onClick
                    )
            )
        }


    }
}

@Composable
fun DigitalLemonadeApp() {

    var currentStage by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    when (currentStage) {

        1 -> {
            DigitalLemonade(
                stringResource = R.string.select_lemon,
                drawable = R.drawable.lemon_tree,
                contentDescription = R.string.lemon_tree_content_description,
                onClick = {
                    currentStage++

                    squeezeCount = (2..4).random()
                }
            )
        }
        2 -> {
            val context = LocalContext.current
            DigitalLemonade(
                stringResource = R.string.squeeze_lemon,
                drawable = R.drawable.lemon_squeeze,
                contentDescription = R.string.lemon_content_description,
                onClick = {
                    squeezeCount--
                    Toast.makeText(
                        context,
                        "Continue click to squeeze lemon",
                        Toast.LENGTH_SHORT
                    ).show()
                    if (squeezeCount == 0) {
                        currentStage++
                    }
                }
            )
        }
        3 -> {
            DigitalLemonade(
                stringResource = R.string.drink_lemonade,
                drawable = R.drawable.lemon_drink,
                contentDescription = R.string.glass_of_lemonade_content_description,
                onClick = {
                    currentStage++
                }
            )
        }
        4 -> {
            DigitalLemonade(
                stringResource = R.string.tap_to_empty,
                drawable = R.drawable.lemon_restart,
                contentDescription = R.string.empty_glass_content_description,
                onClick = {
                    currentStage = 1
                })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DigitalLemonadeAppPreview() {
    DigitalLemonadeApp()
}