package com.example.netflixcloneui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
@Preview
fun MainScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        TopBar()
        NavBar()
        MovieDisplay()
        MovieSlider("Watch It Again")
        MovieSlider(movieType = "Drama Movies")
        MovieSlider(movieType = "Action Movies")
        MovieSlider(movieType = "Thriller Movies")
        MovieSlider(movieType = "New Releases")
    }
}

@Composable
fun TopBar(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(painter = painterResource(id = R.drawable.netflix),
            contentDescription = "netflix_logo",
            modifier = Modifier.size(60.dp))
        Row (
            modifier = Modifier.wrapContentWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(45.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(45.dp)
            )
        }

    }
}

@Composable
fun NavBar(){
    Row (
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .background(Color.Black),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "TVShows",
            color = Color.LightGray,
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 20.sp)

        Text(text = "Movies",
            color = Color.LightGray,
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 20.sp)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categories",
                color = Color.LightGray,
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 20.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_drop),
                contentDescription = "drop",
                modifier = Modifier.size(35.dp)
            )
        }
    }
}

@Composable
fun MovieDisplay(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.wallpaper_9),
            contentDescription = "wp9",
            modifier = Modifier
                .padding(vertical = 20.dp)
                .size(350.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Action", color = Color.White, fontSize = 17.sp)
            Text(text = "Superhero", color = Color.White, fontSize = 17.sp)
            Text(text = "Thriller", color = Color.White, fontSize = 17.sp)
            Text(text = "Fantasy", color = Color.White, fontSize = 17.sp)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "add")
                Text(text = "My List", color = Color.White)
            }

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Play", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "info")
                Text(text = "Info", color = Color.White)
            }
        }
    }
}

@Composable
fun PosterCompose(imageRes: Int){
    Image(painter = painterResource(id = imageRes),
        contentDescription = "wp",
        modifier = Modifier
            .width(200.dp)
            .height(250.dp))
}

@Composable
fun MovieSlider(movieType :String){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Text(text = movieType,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, top = 30.dp, bottom = 10.dp))

        LazyRow{
            itemsIndexed(ShuffleMovieList()){ index, item ->
                PosterCompose(imageRes = item.imageRes)
            }
        }
    }
}

fun ShuffleMovieList(): List<MoviePosterClass>{
    val posterList = mutableListOf<MoviePosterClass>()
    posterList.add(MoviePosterClass(R.drawable.wallpaper_1))
    posterList.add(MoviePosterClass(R.drawable.wallpaper_2))
    posterList.add(MoviePosterClass(R.drawable.wallpaper_3))
    posterList.add(MoviePosterClass(R.drawable.wallpaper_4))
    posterList.add(MoviePosterClass(R.drawable.wallpaper_5))
    posterList.add(MoviePosterClass(R.drawable.wallpaper_7))
    posterList.add(MoviePosterClass(R.drawable.wallpaper_8))
    posterList.add(MoviePosterClass(R.drawable.wallpaper_9))

    posterList.shuffle()
    return posterList
}

data class MoviePosterClass(
    val imageRes: Int
)