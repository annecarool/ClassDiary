package com.example.classdiary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.classdiary.ui.theme.ClassDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassDiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppClassDiary()
                }
            }
        }
    }
}

@Composable
fun AppClassDiary() {
    ClassDiaryStructure()
}

@Preview
@Composable
fun ClassDiaryStructure() {

    var expandir by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color(255, 255, 255)),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(2.dp, Color(255, 255, 255)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium

                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mario),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .border(
                            width = (1.dp),
                            color = Color(255, 255, 255),
                            CircleShape
                        )
                        .clip(CircleShape)
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    Text(
                        text = stringResource(id = R.string.student1_name),
                        modifier = Modifier
                            .clickable { expandir = !expandir }
                            .padding(bottom = 10.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = stringResource(id = R.string.student1_curso),
                        modifier = Modifier
                            .clickable { expandir = !expandir },
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )
                }
                Icon(
                    imageVector =
                    if (expandir)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color(0, 0, 0),
                    modifier = Modifier
                        .clickable {expandir = !expandir}
                )
            }

            if (expandir == true) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.student1_nota),
                        modifier = Modifier
                            .padding(20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = stringResource(id = R.string.student1_faltas),
                        modifier = Modifier
                            .padding(20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color(0, 0, 0),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )

                }
            }
        }

    }

}