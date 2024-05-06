package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun LogoAndName() {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Android logo",
            modifier = Modifier.fillMaxWidth(0.3f)
        )
        Text(
            text = "Cristian Lahoz",
            fontSize = 48.sp,
            color = Color.White
        )
        Text(
            text = "Android Developer",
            fontSize = 24.sp,
            color = Color.Green
        )
    }
}


@Composable
fun Contact() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Icono de Estrella",
                tint = Color.LightGray,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "g.dev/lahozcristian",
                color = Color.LightGray
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                Icons.Filled.Email,
                contentDescription = "Icono de Email",
                tint = Color.LightGray,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "lahozcristian@gmail.com",
                color = Color.LightGray
            )
        }
        Row {
            Icon(
                Icons.Filled.Phone,
                contentDescription = "Icono de Teléfono",
                tint = Color.LightGray,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "(264) 4123456",
                color = Color.LightGray
            )
        }
    }
}


@Composable
fun BusinessCard() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {}
        LogoAndName()
        Contact()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}