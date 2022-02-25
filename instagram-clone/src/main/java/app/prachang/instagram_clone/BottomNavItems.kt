package app.prachang.instagram_clone

import app.prachang.dummy_data.R


enum class BottomNavItems(
    val label: String,
    val route: String,
    val icon: Int,
    val selectedIcon: Int,
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
        icon = R.drawable.ic_home_outlined,
        selectedIcon = R.drawable.ic_home_filled,
    ),
    AddPost(
        label = "Add Post",
        route = "addpost",
        icon = R.drawable.ic_home_outlined,
        selectedIcon = R.drawable.ic_home_filled,
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