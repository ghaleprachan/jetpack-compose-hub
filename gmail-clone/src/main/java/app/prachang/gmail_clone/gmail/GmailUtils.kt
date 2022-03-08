package app.prachang.gmail_clone.gmail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

internal enum class BottomNavItems(
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

internal val colors = listOf(
    Color(0xFF2196F3),
    Color(0xFFA6AEDD),
    Color(0xFFFF9800),
    Color(0xFF4CAF50),
)

internal enum class DrawerItems(val label: String, val icon: ImageVector) {
    Primary("Primary", Icons.Outlined.StayPrimaryPortrait), Social(
        "Social",
        Icons.Outlined.PersonOutline
    ),
    Promotions("Promotions", Icons.Outlined.Image), Starred(
        "Starred",
        Icons.Outlined.StarOutline
    ),
    Snoozed("Snoozed", Icons.Outlined.LockClock), Important("Important", Icons.Outlined.Save), Send(
        "Important",
        Icons.Outlined.Send
    ),
    Scheduled("Scheduled", Icons.Outlined.ScheduleSend), Outbox(
        "OutBox",
        Icons.Outlined.Outbox
    ),
    Drafts("Drafts", Icons.Outlined.Drafts), AllMail(
        "All Mails",
        Icons.Outlined.Message
    ),
    Span("Span", Icons.Outlined.LockClock), Bin(
        "Bin",
        Icons.Outlined.DeleteOutline
    ),
    Calendar("Calendar", Icons.Outlined.CalendarViewDay), Contacts(
        "Contacts",
        Icons.Outlined.Contacts
    ),
    Settings("Settings", Icons.Outlined.Settings), Help(
        "Help and feedback",
        Icons.Outlined.HelpOutline
    ),
}


internal data class Gmail(
    val image: String?,
    val name: String?,
    val gmail: String,
    val activeAccount: Boolean = false,
)

internal val gmailList = listOf(
    Gmail(
        image = "https://thehimalayantimes.com/uploads/imported_images/wp-content/uploads/2020/07/RAJESH-HAMAL-INSTAGRAM.jpg",
        name = "Rajesh Hamal",
        gmail = "rajeshdai57@gmail.com",
        activeAccount = true,
    ),
    Gmail(
        image = "https://www.celebrityborn.com/admin/assets/images/people/nikhil_upreti_778.jpg",
        name = "Nikhil Upreti",
        gmail = "nikhil97@gmail.com",
    ),
    Gmail(
        image = "https://articlebio.com/uploads/2014/S/shreekrishna_shrestha.jpg",
        name = "Shree Krishna Shrestha",
        gmail = "stha1st@gmail.com"
    )
)