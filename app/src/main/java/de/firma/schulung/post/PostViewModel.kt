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

    val loading = MutableStateFlow(false)
    val posts = MutableStateFlow(emptyList<Post>())

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            loading.update { true }
            posts.update { api.fetchPosts(20) }
            loading.update { false }
        }
    }
}