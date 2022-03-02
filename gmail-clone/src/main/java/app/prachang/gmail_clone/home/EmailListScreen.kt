package app.prachang.gmail_clone.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Beenhere
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.prachang.common_compose_ui.extensions.Width
import app.prachang.dummy_data.gmail.MailsData
import app.prachang.dummy_data.gmail.MailsDataTable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmailListScreen(
    scrollState: LazyListState, contentPadding: PaddingValues
) {
    EmailListContent(
        scrollState = scrollState, contentPadding = contentPadding
    )
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun EmailListContent(
    scrollState: LazyListState, contentPadding: PaddingValues
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        state = scrollState,
        content = {
            item {
                Text(text = "Primary", color = Color.Gray, fontSize = 14.sp)
            }
            items(MailsData.mails) { mail ->
                if (mail.tags == MailsData.Tags.Email) {
                    EmailItem(mail = mail)
                } else {
                    OtherItem(type = mail.tags)
                }
            }
        },
    )
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
        "Android Authority, Stackshare  Weekly, Quora, Android Authority",
        "Promotions"
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

val colors = listOf(
    Color(0xFF2196F3),
    Color(0xFFA6AEDD),
    Color(0xFFFF9800),
    Color(0xFF4CAF50),
)

