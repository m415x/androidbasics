package com.example.jetpackcomposetutorial

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        title = stringResource(R.string.title_text),
                        paragraph1 = stringResource(R.string.first_paragraph_text),
                        paragraph2 = stringResource(R.string.second_paragraph_text),
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(
    title: String,
    paragraph1: String,
    paragraph2: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = paragraph1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = paragraph2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}


@Composable
fun GreetingImage(
    title: String,
    paragraph1: String,
    paragraph2: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = "Header image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
        )
        GreetingText(
            title = title,
            paragraph1 = paragraph1,
            paragraph2 = paragraph2
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        GreetingImage(
            title = stringResource(R.string.title_text),
            paragraph1 = stringResource(R.string.first_paragraph_text),
            paragraph2 = stringResource(R.string.second_paragraph_text),
            modifier = Modifier
        )
    }
}