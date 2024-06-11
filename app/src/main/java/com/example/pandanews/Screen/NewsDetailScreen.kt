package com.example.pandanews.Screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pandanews.R
import com.example.pandanews.network.NewsModel


@Composable
fun NewsDetailScreen(article: NewsModel.Article?) {



    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title = { Text("Panda News") },
                modifier = Modifier.height(48.dp),
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = article!!.title!!,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    maxLines = 3
                )

                Spacer(modifier = Modifier.height(10.dp))

                Card {
                    Row(modifier = Modifier.fillMaxWidth()) {


                        if (article.urlToImage == null) {
                            Image(
                                painter = painterResource(id = R.drawable.newslogobig),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(225.dp),
                                contentScale = ContentScale.FillBounds
                            )
                        } else {
                            AsyncImage(
                                model = article.urlToImage,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp),
                                contentScale = ContentScale.Crop
                            )
                        }


                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = article.content!!,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(6.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = {


                        },
                        modifier = Modifier
                            .padding(2.dp)

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.volume_up_24px),
                            contentDescription = "VolumeButton"
                        )
                    }
                }




                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = article.author!!)
                    Text(text = article.publishedAt!!)
                }

            }
        }
    }
}







