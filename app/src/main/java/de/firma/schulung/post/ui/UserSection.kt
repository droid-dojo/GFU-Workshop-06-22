package de.firma.schulung.post.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.firma.schulung.post.model.User

@Composable
fun UserSection(
    user: User,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        UserAvatar(url = user.profilePictureUrl)
        Column() {
            Text(text = user.name)
            Text(text = user.location)
        }
    }
}

@Preview
@Composable
fun UserSectionPreview() {
    val dummy = User(
        name = "Hans Dampf",
        location = "Irgendwo",
        profilePictureUrl = ""
    )

    UserSection(user = dummy)
}