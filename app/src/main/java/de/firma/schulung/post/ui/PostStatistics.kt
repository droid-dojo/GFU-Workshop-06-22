package de.firma.schulung.post.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PostStatistics(
    likes: Int,
    comments: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        TextButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null
            )
            Text(text = "$likes")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
            Text(text = "$comments")
        }
    }
}

@Preview
@Composable
fun PostStatisticsPreview() {
    PostStatistics(likes = 0, comments = 0)
}