package de.firma.schulung.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.firma.schulung.clock.ui.ClockDisplay
import de.firma.schulung.post.api.FakeApi
import de.firma.schulung.post.model.Post
import de.firma.schulung.post.model.User
import de.firma.schulung.post.ui.PostCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

@Composable
fun PostScreen() {
    var posts by remember {
        mutableStateOf(emptyList<Post>())
    }

    LaunchedEffect("sample") {
        posts = withContext(Dispatchers.IO) {
            FakeApi().fetchPosts(20)
        }
    }

    if (posts.isEmpty()) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
        )
    } else {
        PostScreen(posts = posts)
    }

}

@Composable
fun PostScreen(posts: List<Post>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        item {
            ClockDisplay()
        }

        items(posts) {
            PostCard(post = it)
        }
    }
}

@Preview
@Composable
fun PostScreenPreview() {
    val dummyPosts = List(20) {
        Post(
            user = User(
                name = "Sample User $it",
                location = "Nowhere",
                profilePictureUrl = "https://images.unsplash.com/profile-1609545740442-928866556c38image?dpr=1&auto=format&fit=crop&w=32&h=32&q=60&crop=faces&bg=fff"

            ),
            likes = it,
            comments = Random.nextInt(from = 0, until = 99),
            pictureUrl = "https://images.unsplash.com/photo-1599420186946-7b6fb4e297f0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"

        )
    }

    PostScreen(posts = dummyPosts)

}