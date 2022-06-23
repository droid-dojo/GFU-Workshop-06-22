package de.firma.schulung.news.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.font.FontStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import de.firma.schulung.news.NewsViewModel

@Composable
fun NewsScreen() {

    val vm: NewsViewModel = viewModel()

    val state = vm.state.collectAsState().value

    val listState = rememberLazyListState()

    LaunchedEffect(state.news) {
        if(state.news.isNotEmpty()) {
            listState.animateScrollToItem(state.news.lastIndex)
        }
    }



    LazyColumn(state = listState) {
        items(state.news) {
            Card {
                Column {
                    Text(it.title, fontStyle = FontStyle.Italic)
                    AsyncImage(model = it.imageUrl, contentDescription = it.title)

                    Text(it.content)
                }
            }
        }

        item {
            Button(onClick = { vm.refresh() }) {
                Text("Refresh")
            }
        }

        if (state.loading) {
            item {
                CircularProgressIndicator()
            }
        }

    }


}