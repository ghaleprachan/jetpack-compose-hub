package app.prachang.instagram_clone

import androidx.annotation.DrawableRes
import app.prachang.dummy_data.R


enum class BottomNavItems(
    val label: String,
    val route: String,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
) {
    Home(
        label = "Home",
        route = "home",
        icon = R.drawable.ic_home_outlined,
        selectedIcon = R.drawable.ic_home_filled,
    ),
    Search(
        label = "Search",
        route = "Search",
        icon = R.drawable.ic_search_outlined,
        selectedIcon = R.drawable.ic_search_filled,
    ),
    AddPost(
        label = "Add Post",
        route = "addpost",
        icon = R.drawable.ic_outlined_add,
        selectedIcon = R.drawable.ic_outlined_add,
    ),
    Shop(
        label = "Shop",
        route = "shop",
        icon = R.drawable.ic_home_outlined,
        selectedIcon = R.drawable.ic_home_filled,
    ),
    Profile(
        label = "Profile",
        route = "profile",
        icon = R.drawable.ic_home_outlined,
        selectedIcon = R.drawable.ic_home_filled,
    )
}