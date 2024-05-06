package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ShowArtGallery()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ShowArtGallery()
    }
}

@Composable
fun ShowArtGallery() {
    var idArtwork by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray,
    ) {
        ShowArtwork(
            idArtwork,
            onClickPrevious = { if(idArtwork > 1) idArtwork-- else idArtwork = 3 },
            onClickNext = { if(idArtwork < 3) idArtwork++ else idArtwork = 1 }
        )
    }
}

@Composable
fun ShowArtwork(
    idArtwork: Int,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit
) {
    val imageResource = when (idArtwork) {
        1 -> R.drawable.art_space__1_
        2 -> R.drawable.art_space__2_
        3 -> R.drawable.art_space__3_
        else -> throw IllegalArgumentException("Invalid artwork ID")
    }
    val nameResource = when (idArtwork) {
        1 -> R.string.name_1
        2 -> R.string.name_2
        3 -> R.string.name_3
        else -> throw IllegalArgumentException("Invalid artwork ID")
    }
    val authorResource = when (idArtwork) {
        1 -> R.string.author_1
        2 -> R.string.author_2
        3 -> R.string.author_3
        else -> throw IllegalArgumentException("Invalid artwork ID")
    }
    val yearResource = when (idArtwork) {
        1 -> R.string.year_1
        2 -> R.string.year_2
        3 -> R.string.year_3
        else -> throw IllegalArgumentException("Invalid artwork ID")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Artwork section
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(0.60f),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.background(Color(R.color.image_frame))
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = "",
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
        // Description section
        Column(
            modifier = Modifier
                .width(300.dp)
                .background(Color(R.color.text_background))
                .padding(12.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = stringResource(nameResource),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = stringResource(authorResource),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = " (" + stringResource(yearResource) + ")",
                    fontSize = 14.sp,
                )
            }
        }
        // Navigation section
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onClickPrevious,
                    modifier = Modifier.width(120.dp)
                ) {
                    Text(text = "Previous")
                }
//                Spacer(modifier = Modifier.width(64.dp))
                Button(
                    onClick = onClickNext,
                    modifier = Modifier.width(120.dp)
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}