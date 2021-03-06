package de.firma.schulung.post.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.firma.schulung.post.model.Post
import de.firma.schulung.post.model.User


@Composable
fun PostCard(post: Post) {
    Card {
        Column() {
            UserSection(user = post.user, modifier = Modifier.padding(all = 8.dp))
            Picture(url = post.pictureUrl)
            PostStatistics(
                likes = post.likes,
                comments = post.comments,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 24.dp)
            )
        }
    }
}

@Preview
@Composable
fun PostCardPreview() {
    val dummyPost = Post(
        user = User(
            name = "Sample",
            location = "Nowhere",
            profilePictureUrl = "https://images.unsplash.com/profile-1609545740442-928866556c38image?dpr=1&auto=format&fit=crop&w=32&h=32&q=60&crop=faces&bg=fff"
        ),
        likes = 9999,
        comments = 20,
        pictureUrl = "https://images.unsplash.com/photo-1599420186946-7b6fb4e297f0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
    )

    PostCard(post = dummyPost)
}
