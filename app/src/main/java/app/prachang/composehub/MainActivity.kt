package app.prachang.composehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.animations.ExpandableText
import app.prachang.common_compose_ui.components.ComposeImage
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.instagram_clone.homescreen.HomeScreen
import app.prachang.instagram_clone.profilescreen.ProfileScreen
import app.prachang.theme.ComposeHubTheme
import app.prachang.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    // HomeScreen()
                    // ProfileScreen()
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun MainScreen() {
    Scaffold(
        backgroundColor = Color.LightGray,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Sample")
                },
            )
        },
        content = {
            val samples = SampleAppData.SampleAppType.values()
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = {
                    items(samples) { sample ->
                        val expanded = remember {
                            mutableStateOf(false)
                        }

                        val hasSubList = sample.samples.isNotEmpty()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .height(85.dp)
                                .clip(shape = RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .clickable(enabled = hasSubList) {
                                    expanded.value = !expanded.value
                                }
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = sample.icon),
                                contentDescription = null,
                            )
                            Width(width = 12.dp)
                            Text(
                                text = sample.title,
                                style = Typography.h5,
                            )
                        }

                        if (hasSubList) {
                            AnimatedVisibility(
                                visible = expanded.value,
                                enter = expandVertically(),
                                exit = shrinkVertically(),
                            ) {
                                Column {
                                    sample.samples.forEach { sample ->
                                        ListItem(modifier = Modifier.padding(horizontal = 24.dp)) {
                                            Text(
                                                text = sample.label,
                                                color = Color.Gray,
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
            )
        },
    )
}