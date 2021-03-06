package de.firma.schulung.post.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import de.firma.schulung.post.model.User

@Composable
fun UserAvatar(url: String) {
    AsyncImage(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = Color.Gray),
        contentDescription = null,
        model = url,
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun UserAvatarPreview() {
    UserAvatar(url = "")
}