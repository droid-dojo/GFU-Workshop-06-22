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
            profilePictureUrl = ""
        ),
        likes = 9999,
        comments = 20,
        pictureUrl = ""
    )

    PostCard(post = dummyPost)
}
