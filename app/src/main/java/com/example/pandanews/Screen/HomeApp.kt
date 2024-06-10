package com.example.pandanews.Screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pandanews.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeApp(modifier: Modifier = Modifier, viewModel: NewsViewModel) {

    val res = viewModel.res.value!!.articles!!


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PandaNews") },
                navigationIcon = {
                    IconButton(onClick = { }, modifier = Modifier) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search_btn")
                    }
                }, actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Account_btn"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {


            items(res.size) { index ->


                Card(
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .fillMaxWidth()
                        .then(
                            if (index == 0) {
                                Modifier
                                    .height(255.dp)
                            } else {
                                Modifier
                                    .fillMaxWidth()
                                    .height(110.dp)
                            }
                        )
                ) {
                    if (index == 0) {
                        Column {

                            if (res[index]!!.urlToImage == null) {
                                Image(
                                    painter = painterResource(id = R.drawable.newslogo),
                                    contentDescription = "NewsLogo", modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                AsyncImage(
                                    model = res[index]!!.urlToImage,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Column(modifier = Modifier.padding(8.dp)) {
                                Text(
                                    text = res[index]!!.title!!,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 3,
                                    textAlign = TextAlign.Start
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(), // Make the Row fill the width
                                    horizontalArrangement = Arrangement.SpaceBetween // Arrange items with space between
                                ) {

                                    if (res[index]!!.author != null && res[index]!!.publishedAt != null) {
                                        Text(
                                            text = "By ${res[index]!!.author!!}",
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        )
                                        Text(
                                            text = res[index]!!.publishedAt!!,
                                            fontSize = 12.sp,
                                            color = Color.Gray,
                                            maxLines = 1
                                        )
                                    } else if (res[index]!!.author == null) {
                                        Text(
                                            text = "Author Unknown",
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        )
                                    } else if (res[index]!!.publishedAt == null) {
                                        val currentTime = Date()
                                        val formatter =
                                            SimpleDateFormat("yyyy:M:d", Locale.getDefault())
                                        val formattedTime = formatter.format(currentTime)



                                        Text(
                                            text = formattedTime,
                                            modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        )
                                    }


                                }
                            }


                        }
                    } else {
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {

                            if (res[index]!!.urlToImage == null) {
                                Image(
                                    painter = painterResource(id = R.drawable.newslogo),
                                    contentDescription = null,

                                    )
                            } else {
                                AsyncImage(
                                    model = res[index]!!.urlToImage,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(80.dp)
                                        .width(120.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }


                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = res[index]!!.title!!,
                                    modifier = Modifier.padding(start = 8.dp),
                                    fontSize = 16.sp,
                                    maxLines = 3
                                )
                                if (res[index]!!.author != null && res[index]!!.publishedAt != null) {
                                    Row {
                                        Text(
                                            text = "By ${res[index]!!.author!!}",
                                            modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        )
                                        Spacer(modifier = Modifier.weight(1f))
                                        Text(
                                            text = res[index]!!.publishedAt!!,
                                            modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                            fontSize = 12.sp,
                                            color = Color.Gray,
                                            maxLines = 1
                                        )
                                    }
                                } else if (res[index]!!.author == null) {
                                    Row {
                                        Text(
                                            text = "Author Unknown",
                                            modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        )
                                    }
                                } else if (res[index]!!.publishedAt == null) {

                                    val currentTime = Date()
                                    val formatter =
                                        SimpleDateFormat("yyyy:M:d", Locale.getDefault())
                                    val formattedTime = formatter.format(currentTime)


                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = formattedTime,
                                        modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                        fontSize = 12.sp,
                                        color = Color.Gray
                                    )
                                }


                            }
                        }
                    }
                }


            }

        }


    }
}

