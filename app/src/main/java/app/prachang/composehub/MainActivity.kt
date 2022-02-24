package app.prachang.composehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.prachang.common_compose_ui.animations.ExpandableText
import app.prachang.instagram_clone.homescreen.HomeScreen
import app.prachang.instagram_clone.profilescreen.ProfileScreen
import app.prachang.theme.ComposeHubTheme

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
                content = {
                    items(samples) {
                        val expanded = remember {
                            mutableStateOf(false)
                        }

                        val hasSubList = it.samples.isNotEmpty()

                        ListItem(
                            modifier = Modifier
                                .clickable(enabled = hasSubList) {
                                    expanded.value = !expanded.value
                                }
                                .padding(horizontal = 15.dp)
                                .background(Color.White),
                        ) {
                            Text(text = it.title)
                        }

                        if (hasSubList) {
                            AnimatedVisibility(
                                visible = expanded.value,
                                enter = expandVertically(),
                                exit = shrinkVertically(),
                            ) {
                                Column {
                                    it.samples.forEach { sample ->
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