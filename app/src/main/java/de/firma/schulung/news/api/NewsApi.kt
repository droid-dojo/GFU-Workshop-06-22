package de.firma.schulung.news.api

import de.firma.schulung.news.api.models.NewsList
import retrofit2.http.GET

interface NewsApi {
    @GET("https://inshorts.deta.dev/news?category=science")
    suspend fun fetchNews() : NewsList
}
