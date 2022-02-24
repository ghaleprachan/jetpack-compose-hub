package app.prachang.composehub

import androidx.annotation.DrawableRes

object SampleAppData {

    enum class SampleAppType(
        val title: String,
        @DrawableRes val icon: Int,
        val samples: List<SampleApp> = emptyList(),
    ) {
        DemoApps(
            title = "Demo Apps",
            icon = R.drawable.ic_launcher_foreground,
            samples = demoApps,
        ),
        Animations(
            title = "Animations",
            icon = R.drawable.ic_launcher_foreground,
        ),
        Themes(
            title = "Themes",
            icon = R.drawable.ic_launcher_foreground,
            samples = demoApps,
        ),
    }

    data class SampleApp(
        val label: String,
        val route: String,
        @DrawableRes val icon: Int?,
    )

    val demoApps = listOf(
        SampleApp(
            label = "Instagram", route = "instagram", icon = R.drawable.ic_launcher_foreground
        ),
        SampleApp(
            label = "Gmail", route = "gmail", icon = R.drawable.ic_launcher_foreground
        ),
        SampleApp(
            label = "Facebook", route = "facebook", icon = R.drawable.ic_launcher_foreground
        ),
    )
}
