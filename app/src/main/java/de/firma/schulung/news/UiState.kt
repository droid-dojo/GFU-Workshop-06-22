package de.firma.schulung.news

import de.firma.schulung.news.api.models.News

data class UiState(
    val loading: Boolean,
    val news: List<News>
)