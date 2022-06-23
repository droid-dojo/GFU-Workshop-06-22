package de.firma.schulung.news.api.models

import kotlinx.serialization.Serializable

@Serializable
data class NewsList(
    val category: String,
    val data: List<News>,
    val success: Boolean
)