package de.firma.schulung.post.api

import de.firma.schulung.post.model.Post
import de.firma.schulung.post.model.User
import kotlinx.coroutines.delay
import kotlin.random.Random

class FakeApi {

    suspend fun fetchPosts(amount: Int): List<Post> {

        delay(5_000)

        return List(amount) {
            Post(
                user = User(
                    name = "From API",
                    location = "Nowhere",
                    profilePictureUrl = "https://images.unsplash.com/profile-1609545740442-928866556c38image?dpr=1&auto=format&fit=crop&w=32&h=32&q=60&crop=faces&bg=fff"
                ),
                likes = Random.nextInt(from = 0, until = 200),
                comments = Random.nextInt(from = 0, until = 200),
                pictureUrl = "https://images.unsplash.com/photo-1599420186946-7b6fb4e297f0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
            )
        }
    }
}