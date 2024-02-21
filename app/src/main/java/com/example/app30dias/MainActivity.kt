package com.example.app30dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app30dias.data.GamesRepository
import com.example.app30dias.ui.theme.App30DiasTheme
import com.example.app30dias.ui.theme.changeIconColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App30DiasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GamesApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesApp(modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            GamesTopAppBar()
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondary),
        ) {

            // Aquí es donde usamos GamesRepository.games en lugar de una referencia directa a 'games'
            items(GamesRepository.games) { game ->

                GameItem(
                    game = game,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesTopAppBar(modifier: Modifier = Modifier) {
    val icon = changeIconColor()
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),

                    painter = icon,
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },

    )
}

@Preview
@Composable
fun GamePreview() {
    App30DiasTheme() {
        GamesApp()
    }
}


