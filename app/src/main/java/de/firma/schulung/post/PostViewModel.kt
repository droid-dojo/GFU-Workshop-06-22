package de.firma.schulung.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.firma.schulung.post.api.FakeApi
import de.firma.schulung.post.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val api = FakeApi()

    val state = MutableStateFlow(
        UiState(loading = false, posts = emptyList())
    )

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            state.update {
                it.copy(loading = true)
            }

            state.update {
                it.copy(
                    loading = false,
                    posts = api.fetchPosts(20)
                )
            }
        }
    }
}

data class UiState(
    val loading: Boolean,
    val posts: List<Post>
)