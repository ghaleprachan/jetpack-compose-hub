package app.prachang.instagram_clone.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.extensions.Height
import app.prachang.dummy_data.image2
import app.prachang.dummy_data.instagram.profileData

@Composable
internal fun TopContent() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            CircleImage(
                modifier = Modifier.size(85.dp),
                url = image2,
            )
            Spacer(modifier = Modifier.width(8.dp))
            FollowMeter(
                modifier = Modifier.weight(1f), count = profileData.totalPosts, label = "Posts"
            )
            FollowMeter(
                modifier = Modifier.weight(1f),
                count = profileData.followerCount,
                label = "Followers"
            )
            FollowMeter(
                modifier = Modifier.weight(1f),
                count = profileData.followingCount,
                label = "Following"
            )
        }
        Height(height = 8.dp)
        Text(
            text = profileData.name, fontSize = 16.sp, fontWeight = FontWeight.Black
        )
        Text(text = "Athlete", fontSize = 14.sp)
        Height(height = 8.dp)

        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
        ) {
            Text(text = "Edit Profile", color = Color.Black)
        }
    }
}


@Composable
private fun FollowMeter(
    modifier: Modifier, count: String? = "2", label: String = "Posts"
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .clickable {

            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = count ?: "0", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = label, fontSize = 13.sp, fontWeight = FontWeight.Light
        )
    }
}
