package app.prachang.composehub

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.dummy_data.instagram.profileData
import app.prachang.theme.ComposeHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Preview(showSystemUi = true)
@Composable
internal fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = profileData.username,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )
        }
    ) {
        LazyColumn(
            content = {
                item {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(Modifier.height(IntrinsicSize.Min)) {
                            Image(
                                modifier = Modifier
                                    .size(size = 80.dp)
                                    .clip(shape = CircleShape),
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null,
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            FollowMeter(
                                modifier = Modifier.weight(1f),
                                count = "520",
                                label = "Posts"
                            )
                            FollowMeter(
                                modifier = Modifier.weight(1f),
                                count = "16.2M",
                                label = "Followers"
                            )
                            FollowMeter(
                                modifier = Modifier.weight(1f),
                                count = "1",
                                label = "Following"
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Prachan Ghale",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black
                        )
                        Text(text = "Programmer", fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                stickyHeader {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .background(Color.Gray)
                    ) {

                    }
                }
                items((1..25).toList()) {
                    ListItem {
                        Text(text = "Test Title $it")
                    }
                }
            }
        )
    }
}

@Composable
fun FollowMeter(
    modifier: Modifier,
    count: String? = "2",
    label: String = "Posts"
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
            text = count ?: "0",
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Light
        )
    }
}