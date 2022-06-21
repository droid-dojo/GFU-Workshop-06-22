package de.firma.schulung.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.firma.schulung.post.model.Post
import de.firma.schulung.post.model.User
import de.firma.schulung.post.ui.PostCard
import kotlin.random.Random

@Composable
fun PostScreen(posts: List<Post>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        items(posts) {
            PostCard(post = it)
        }
    }
}

@Preview
@Composable
fun PostScreenPreview() {
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


    val dummyPosts = List(20) {
        Post(
            user = User(
                name = "Sample User $it",
                location = "Nowhere",
                profilePictureUrl = ""
            ),
            likes = it,
            comments = Random.nextInt(from = 0, until = 99),
            pictureUrl = ""
        )
    }

    PostScreen(posts = dummyPosts)

}