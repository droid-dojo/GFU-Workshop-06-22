package de.firma.schulung.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import de.firma.schulung.news.api.NewsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class NewsViewModel : ViewModel() {

    val contentType = "application/json".toMediaType()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(Json {
            ignoreUnknownKeys = true
        }.asConverterFactory(contentType))
        .build()

    private val api: NewsApi = retrofit.create(NewsApi::class.java)

    private val _state = MutableStateFlow(UiState(loading = false, news = emptyList()))
    val state: StateFlow<UiState> = _state

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {

            _state.update { it.copy(loading = true) }

            val fetched = api.fetchNews()

            _state.update {
                it.copy(loading = false, news = fetched.data)
            }
        }
    }
}

