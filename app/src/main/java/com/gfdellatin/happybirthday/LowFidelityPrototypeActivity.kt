package com.gfdellatin.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gfdellatin.happybirthday.ui.theme.HappyBirthdayTheme

class LowFidelityPrototypeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                ComposableBusinessCard()
            }
        }
    }
}

@Composable
fun ComposableBusinessCard() {
    val colorDarcula = Color.DarkGray
    Column(
        modifier = Modifier
            .background(
                color = colorDarcula
            )
            .fillMaxWidth()
    ) {
        ComposablePersonInformation(
            fullName = stringResource(id = R.string.full_name),
            title = stringResource(id = R.string.title_business_card),
            textColor = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(4.dp)
        )
        Spaces(32.dp)
        ComposableTechnologies(
            technologies = stringResource(id = R.string.title_technologies),
            textColor = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(4.dp)
        )
        Spaces(32.dp)
        ComposableContactDetails()
    }
}

@Composable
fun ComposablePersonInformation(
    fullName: String,
    title: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    val meImage = painterResource(id = R.drawable.me)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            Image(
                painter = meImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)

            )
            Column {
                Text(
                    text = fullName,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                )
                Text(
                    text = title,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.Start)
                )
            }

        }
    }
}

@Composable
fun ComposableTechnologies(
    technologies: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    val androidIcon = painterResource(id = R.drawable.android_logo)
    val kotlinIcon = painterResource(id = R.drawable.kotlin_icon)
    val androidMobileIcon = painterResource(id = R.drawable.androidmobile_phone)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = technologies,
            color = textColor,
            textAlign = TextAlign.Justify,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Row {
            Image(
                painter = androidIcon,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(
                        width = 125.dp,
                        height = 125.dp
                    )
                    .padding(12.dp)

            )
            Image(
                painter = kotlinIcon,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(
                        width = 125.dp,
                        height = 125.dp
                    )
                    .padding(12.dp)
            )
            Image(
                painter = androidMobileIcon,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(
                        width = 125.dp,
                        height = 125.dp
                    )
                    .padding(12.dp)
            )
        }
    }

}

@Composable
fun ComposableContactDetails() {
    Column {
        Divider(
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(16.dp)
        )
        ComposableDetail(
            icon = R.drawable.ic_baseline_phone,
            info = stringResource(id = R.string.info_personal_phone),
            textColor = colorResource(id = R.color.white)
        )
        Divider(
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(16.dp)
        )
        ComposableDetail(
            icon = R.drawable.ic_baseline_share,
            info = stringResource(id = R.string.info_personal_share),
            textColor = colorResource(id = R.color.white)
        )
        Divider(
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(16.dp)
        )
        ComposableDetail(
            icon = R.drawable.ic_baseline_email,
            info = stringResource(id = R.string.info_personal_mail),
            textColor = colorResource(id = R.color.white)
        )
    }

}

@Composable
fun ComposableDetail(
    @DrawableRes
    icon: Int,
    info: String,
    textColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = textColor
        )
        Text(
            text = info,
            color = textColor,
            textAlign = TextAlign.Justify,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }
}

@Composable
fun Spaces(
    pixels: Dp
) {
    Spacer(modifier = Modifier.padding(pixels))
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

@Preview(
    showBackground = true
)
@Composable
fun ComposablePersonInformationPreview() {
    HappyBirthdayTheme {
        ComposablePersonInformation(
            fullName = stringResource(id = R.string.full_name),
            title = stringResource(id = R.string.title_business_card),
            textColor = colorResource(id = R.color.black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposableTechnologiesPreview() {
    ComposableTechnologies(
        technologies = stringResource(id = R.string.title_technologies),
        textColor = colorResource(id = R.color.black)
    )
}

@Preview(showBackground = true)
@Composable
fun SpacesPreview() {
    Spaces(16.dp)
}

@Preview(showBackground = true)
@Composable
fun ComposableDetailPreview() {
    ComposableDetail(
        icon = R.drawable.ic_baseline_phone,
        "+55 (11) 11111-1111",
        textColor = colorResource(id = R.color.black)
    )
}