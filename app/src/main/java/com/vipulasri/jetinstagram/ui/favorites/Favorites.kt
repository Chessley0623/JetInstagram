package com.vipulasri.jetinstagram.ui.favorites




import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.theme.JetInstagramTheme
import com.vipulasri.jetinstagram.ui.theme.button_blue
import com.vipulasri.jetinstagram.ui.theme.typography



@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {


    Scaffold {
        Column {
            TopBar()
            Text(text = "New posts from your favorites will appear higher in feed. Only you can see who you add or remove. How it works",
                modifier.background(Color.LightGray))
            SearchBar()
            FavoritesProfiles()
        }
    }

}

@Composable
fun TopBar(modifier: Modifier = Modifier){
  Surface(modifier) {
      Row(verticalAlignment = Alignment.CenterVertically, 
          modifier = Modifier.fillMaxWidth()) {
          IconButton(onClick = { /*TODO*/ }) {
              Icon(imageVector = Icons.Filled.Close, contentDescription = "close")
          }
          Text(text = "Favorites")
          IconButton(onClick = { /*TODO*/ }) {
              Icon(imageVector = Icons.Filled.Add, contentDescription = "close")
          }
      }
      
  }

}

@Composable
private fun FavoritesProfiles(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) {"$it"}
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            FavoriteCollectionCard(
                drawable = R.drawable.ab1_inversions,
                text = "Test $name",
                text2 = "@test$name")
        }
    }
}

    @Composable
    fun FavoriteCollectionCard(
        @DrawableRes drawable: Int,
        text: String,
        text2: String,
        modifier: Modifier = Modifier
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(200.dp)
                    .padding(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(drawable),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                    ) {
                        Text(
                            text = text,
                            style = typography.subtitle2,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        Text(
                            text = text2,
                            style = typography.body2,
                            modifier = Modifier.padding(horizontal = 6.dp)
                        )
                    }
                }
                Button(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .width(96.dp),
                    colors = ButtonDefaults.buttonColors(button_blue)
                    ,
                    onClick = { /*TODO*/ })
                {
                    Text(
                        text = "Add",
                        color = Color.White,
                        style = typography.button
                    )
                }
            }
        }
    }

    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier.padding(8.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray
            ),
            placeholder = {
                Text(stringResource(R.string.placeholder_search))
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun SearchBarPreview() {
        JetInstagramTheme { SearchBar(Modifier.padding(8.dp)) }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, widthDp = 320)
    @Composable
    fun FavoriteCollectionCardPreview() {
        JetInstagramTheme {
            FavoriteCollectionCard(
                text = "Test",
                text2 = "@test2",
                drawable = R.drawable.ab1_inversions,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetInstagramTheme {
        FavoritesProfiles()
    }
}

@Preview
@Composable
fun TopBarPreview(){
    JetInstagramTheme {
    TopBar()
    }
}

@Preview
@Composable
fun ScreenPreview(){
    JetInstagramTheme {
        FavoritesScreen()
    }
}
