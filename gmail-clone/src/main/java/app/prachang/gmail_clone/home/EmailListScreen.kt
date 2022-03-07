@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package app.prachang.gmail_clone.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Beenhere
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.prachang.android_common.apputils.LoadingState
import app.prachang.android_common.apputils.LoadResults
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.dummy_data.gmail.MailsData
import app.prachang.dummy_data.gmail.MailsDataTable
import app.prachang.gmail_clone.gmail.colors
import app.prachang.theme.materialyoutheme.Material3Colors

@Composable
internal fun EmailListScreen(
    scrollState: LazyListState,
    homeViewModel: HomeViewModel = hiltViewModel(),
    isScrollingUp: Boolean,
) {
    val gmailState = homeViewModel.gmailList.collectAsState()
    EmailListScreen(
        scrollState = scrollState, isScrollingUp = isScrollingUp, gmailState = gmailState
    )
}

@OptIn(
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
private fun EmailListScreen(
    scrollState: LazyListState,
    isScrollingUp: Boolean,
    gmailState: State<LoadResults<List<MailsDataTable>>>,
) {
    Scaffold(floatingActionButton = {
        ExpandableFloatingButton(isScrollingUp = isScrollingUp)
    }) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            state = scrollState,
            content = {
                item {
                    Text(text = "Primary", color = Color.Gray, fontSize = 14.sp)
                }
                if (gmailState.value is LoadingState) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = Material3Colors.surface)
                        }
                    }
                }
                items(gmailState.value.data.orEmpty()) { mail ->
                    if (mail.tags == MailsData.Tags.Email) {
                        EmailItem(mail = mail)
                    } else {
                        OtherItem(type = mail.tags)
                    }
                }
            },
        )
    }
}

@Composable
private fun EmailItem(mail: MailsDataTable) {
    val color = remember {
        colors.random()
    }
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Surface(
            color = color,
            shape = CircleShape,
            modifier = Modifier.size(45.dp),
        ) {
            Text(
                text = "${mail.sender?.first()}",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = mail.sender.orEmpty(),
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = if (mail.isRead) FontWeight.Normal else FontWeight.Bold
                    )
                )
                Text(
                    text = mail.dataTime.orEmpty(),
                    style = TextStyle(
                        color = Color.DarkGray, fontSize = 12.sp,
                    ),
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = mail.subTitle.orEmpty(),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = if (mail.isRead) FontWeight.Normal else FontWeight.Bold
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = mail.body.orEmpty(),
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.DarkGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Width(width = 8.dp)
                Icon(
                    Icons.Outlined.StarBorder,
                    tint = Color.Gray,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
private fun OtherItem(
    type: MailsData.Tags
) {
    val icon =
        if (type == MailsData.Tags.Promotions) Icons.Outlined.Beenhere else Icons.Outlined.Person

    val (message, title) = if (type == MailsData.Tags.Promotions) listOf(
        "Android Authority, Stackshare  Weekly, Quora, Android Authority", "Promotions"
    ) else listOf("Linkedin, Youtube, Facebook", "Social")

    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF4CAF50),
            modifier = Modifier.padding(start = 12.dp, top = 6.dp)
        )

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Text(text = title, style = MaterialTheme.typography.headlineMedium)

                    Text(
                        text = message,
                        style = MaterialTheme.typography.headlineSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableFloatingButton(isScrollingUp: Boolean) {
    Card(
        modifier = Modifier.height(60.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        onClick = {},
        backgroundColor = Material3Colors.secondary
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Icon(Icons.Outlined.Edit, contentDescription = null)
            AnimatedVisibility(visible = isScrollingUp) {
                Row {
                    Width(width = 12.dp)
                    Text(text = "Compose", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

