package de.firma.schulung.post.model

data class Post(
    val user: User,
    val likes: Int,
    val comments: Int,
    val pictureUrl: String,
)