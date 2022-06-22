package de.firma.schulung.post.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import de.firma.schulung.R

@Composable
fun Picture(url: String) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4f / 3f)
            .background(color = Color.Gray),
        model = url,
        contentDescription = stringResource(id = R.string.app_name),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
    )
}