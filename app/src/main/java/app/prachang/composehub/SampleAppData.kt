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
            icon = R.drawable.ic_sample_apps,
            samples = demoApps,
        ),
        Animations(
            title = "Animations",
            icon = R.drawable.ic_animations,
        ),
        Themes(
            title = "Material Design",
            icon = R.drawable.ic_material_design,
            samples = materialDesign,
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
        SampleApp(
            label = "Tweeter", route = "facebook", icon = R.drawable.ic_launcher_foreground
        ),
    )
    val materialDesign = listOf(
        SampleApp(
            label = "App bar",
            route = "appbar",
            icon = R.drawable.ic_launcher_foreground,
        ),
        SampleApp(
            label = "Bottom app bar",
            route = "bottomappbar",
            icon = R.drawable.ic_launcher_foreground
        ),
        SampleApp(
            label = "Buttons",
            route = "buttons",
            icon = R.drawable.ic_launcher_foreground,
        ),
    )
}
