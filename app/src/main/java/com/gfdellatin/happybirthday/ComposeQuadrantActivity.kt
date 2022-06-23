package com.gfdellatin.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gfdellatin.happybirthday.ui.theme.HappyBirthdayTheme

class ComposeQuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposableQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposableQuadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableFunctionCard(
                title = stringResource(id = R.string.quadrant_first_title),
                description = stringResource(id = R.string.quadrant_first_text),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            ComposableFunctionCard(
                title = stringResource(id = R.string.quadrant_second_title),
                description = stringResource(id = R.string.quadrant_second_text),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableFunctionCard(
                title = stringResource(id = R.string.quadrant_third_title),
                description = stringResource(id = R.string.quadrant_third_text),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposableFunctionCard(
                title = stringResource(id = R.string.quadrant_fourth_title),
                description = stringResource(id = R.string.quadrant_fourth_text),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableFunctionCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ComposableQuadrantPreview() {
    HappyBirthdayTheme {
        ComposableQuadrant()
    }
}