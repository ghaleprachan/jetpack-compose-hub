package app.prachang.gmail_clone.gmail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import app.prachang.common_compose_ui.components.CircleImage
import app.prachang.common_compose_ui.extensions.Height
import kotlinx.coroutines.android.awaitFrame

@Composable
internal fun GmailDialog(modifier: Modifier = Modifier, navController: NavHostController) {
    val visible = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true, block = {
        awaitFrame()
        visible.value = true
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = { navController.popBackStack() })
            },
    ) {
        AnimatedVisibility(
            visible = visible.value,
            modifier = modifier,
            enter = slideInVertically(
                tween(500)
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth(),
                ) {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.align(Alignment.CenterStart)
                    ) {
                        Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
                    }
                    Text(
                        text = "Google", modifier = Modifier.align(Alignment.Center)
                    )
                }

                gmailList.forEach {
                    AccountItem(gmail = it)
                }

                ManageAccountItem(icon = Icons.Outlined.PersonAdd, label = "Add another account")
                ManageAccountItem(
                    icon = Icons.Outlined.Settings, label = "Manage accounts on this device"
                )

                Divider()
                Text(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally),
                    text = "Privacy Policy    *    Terms of service",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
private fun AccountItem(
    gmail: Gmail,
) {
    Row(
        modifier = Modifier.padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CircleImage(
            url = gmail.image,
            modifier = Modifier.size(if (gmail.activeAccount) 45.dp else 35.dp),
        )
        Column {
            Text(
                text = gmail.name.orEmpty(),
                style = textStyle,
            )
            Text(
                text = gmail.gmail,
                style = TextStyle(
                    color = Color.Gray, fontSize = 12.sp, fontWeight = FontWeight.Normal
                ),
            )
            if (gmail.activeAccount) {
                Height(height = 12.dp)
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    modifier = Modifier
                        .height(36.dp)
                        .padding(end = 36.dp),
                    border = BorderStroke(
                        width = 1.dp, color = Color.LightGray
                    )
                ) {
                    Text(text = "Manage your Google Account", color = Color.Black)
                }
            }
        }
    }
    if (gmail.activeAccount) {
        Divider()
    }
}

@Composable
private fun ManageAccountItem(
    icon: ImageVector,
    label: String,
) {
    Row(
        modifier = Modifier.padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(18.dp)
        )
        Text(text = label, style = textStyle)
    }
}

private val textStyle = TextStyle(
    color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold
)