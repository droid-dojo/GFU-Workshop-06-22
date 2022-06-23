package de.firma.schulung.news.api.models

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val id: String,
    val author: String,
    val content: String,
    val imageUrl: String,
    val title: String,
)