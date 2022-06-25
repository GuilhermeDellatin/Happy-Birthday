package com.gfdellatin.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gfdellatin.happybirthday.ui.theme.HappyBirthdayTheme

class LowFidelityPrototypeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposableBusinessCard()
                }
            }
        }
    }
}

@Composable
fun ComposableBusinessCard() {
    val imageBackground = painterResource(id = R.drawable.android_logo)
    val colorDarcula = Color.DarkGray
    Box(
        modifier = Modifier.
                background(
                    color = colorDarcula
                )
    ) {
        Image(
            painter = imageBackground,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(
                    width = 125.dp,
                    height = 125.dp
                )
                .align(Alignment.TopCenter)
                .padding(12.dp),

        )
    }
}

@Composable
fun ComposablePersonInformation(
    fullName: String,
    title: String,
    graduation: String
) {
    Column {

    }
}

@Composable
fun ComposableContactDetails() {

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ComposableBusinessCardPreview() {
    HappyBirthdayTheme {
        ComposableBusinessCard()
    }
}

@Composable
fun ComposablePersonInformationPreview() {
    HappyBirthdayTheme {
        ComposablePersonInformation("", "", "")
    }
}