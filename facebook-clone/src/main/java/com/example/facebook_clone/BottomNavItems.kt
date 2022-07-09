package com.example.facebook_clone

import androidx.annotation.DrawableRes

enum class BottomNavItems(
    val label: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int
) {
    Home("Home", R.drawable.ic_home_selected, R.drawable.ic_home),
    Watch("Watch", R.drawable.ic_watch, R.drawable.ic_watch),
    Market("Market", R.drawable.ic_market_place, R.drawable.ic_market_place),
    Profile("Profile", R.drawable.ic_person_profile, R.drawable.ic_person_profile),
    Notification("Notification", R.drawable.ic_notification__selected, R.drawable.ic_notification),
    Menu("Menu", R.drawable.ic_menu, R.drawable.ic_menu)
}