package app.prachang.gmail_clone.gmail

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.MutableState
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

enum class BottomNavItems(
    val label: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    Home(
        "Mail", "route-home", Icons.Filled.Mail, Icons.Outlined.Mail
    ),
    Bookings(
        "Meet", "route-meet", Icons.Filled.VideoCall, Icons.Outlined.VideoCall
    ),
}

val colors = listOf(
    Color(0xFF2196F3),
    Color(0xFFA6AEDD),
    Color(0xFFFF9800),
    Color(0xFF4CAF50),
)

enum class DrawerItems(val label: String, val icon: ImageVector) {
    Primary("Primary", Icons.Outlined.StayPrimaryPortrait),
    Social("Social", Icons.Outlined.PersonOutline),
    Promotions("Promotions", Icons.Outlined.Image),
    Starred("Starred", Icons.Outlined.StarOutline),
    Snoozed("Snoozed", Icons.Outlined.LockClock),
    Important("Important", Icons.Outlined.Save),
    Send("Important", Icons.Outlined.Send),
    Scheduled("Scheduled", Icons.Outlined.ScheduleSend),
    Outbox("OutBox", Icons.Outlined.Outbox),
    Drafts("Drafts", Icons.Outlined.Drafts),
    AllMail("All Mails", Icons.Outlined.Message),
    Span("Span", Icons.Outlined.LockClock),
    Bin("Bin", Icons.Outlined.DeleteOutline),
    Calendar("Calendar", Icons.Outlined.CalendarViewDay),
    Contacts("Contacts", Icons.Outlined.Contacts),
    Settings("Settings", Icons.Outlined.Settings),
    Help("Help and feedback", Icons.Outlined.HelpOutline),
}
