package com.example.lolify

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


private val BackgroundDark = Color(0xFF0B1020)
private val CardDark = Color(0xFF171F35)
private val Purple = Color(0xFF9B7BFF)
private val LightText = Color(0xFFF5F5FF)
private val SecondaryText = Color(0xFF9BA5BD)

@Composable
fun MemeScreen(
    viewModel: MemeViewmodel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchMeme()
    }

    Scaffold(
        containerColor = BackgroundDark
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF202044),
                            BackgroundDark,
                            BackgroundDark
                        )
                    )
                )
                .padding(paddingValues)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Header

                Text(
                    text = "LOLify 😂",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = LightText
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Your daily dose of laughter.",
                    fontSize = 14.sp,
                    color = SecondaryText
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Section Heading

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Today's Meme",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightText
                    )

                    Surface(
                        color = Color(0xFF302653),
                        shape = RoundedCornerShape(50.dp)
                    ) {
                        Text(
                            text = "🔥 TRENDING",
                            modifier = Modifier.padding(
                                horizontal = 12.dp,
                                vertical = 6.dp
                            ),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Purple
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Meme Card

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = CardDark
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {

                    when (val state = uiState) {

                        is MemeUiState.Loading -> {

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(350.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    color = Purple
                                )
                            }
                        }

                        is MemeUiState.Success -> {

                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                // Meme Title

                                Text(
                                    text = state.meme.title,
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = LightText,
                                    lineHeight = 27.sp
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                // Meme Image

                                AsyncImage(
                                    model = state.meme.url,
                                    contentDescription = state.meme.title,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(320.dp)
                                        .clip(
                                            RoundedCornerShape(16.dp)
                                        )
                                        .background(Color(0xFF252D45)),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(18.dp))

                                HorizontalDivider(
                                    color = Color(0xFF303A54)
                                )

                                Spacer(modifier = Modifier.height(14.dp))

                                // Meme Information

                                Text(
                                    text = "r/${state.meme.subreddit}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Purple
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Posted by u/${state.meme.author}",
                                    fontSize = 12.sp,
                                    color = SecondaryText
                                )
                            }
                        }

                        is MemeUiState.Error -> {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(32.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    text = "Oops! 😕",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = LightText
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = state.message,
                                    color = SecondaryText,
                                    textAlign = TextAlign.Center
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Button(
                                    onClick = {
                                        viewModel.fetchMeme()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Purple
                                    )
                                ) {
                                    Text("Try Again")
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Next Meme Button

                Button(
                    onClick = {
                        viewModel.fetchMeme()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple
                    ),
                    enabled = uiState !is MemeUiState.Loading
                ) {

                    Text(
                        text = "Next Meme",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Made with ❤️ for meme lovers",
                    fontSize = 12.sp,
                    color = SecondaryText
                )
            }
        }
    }
}