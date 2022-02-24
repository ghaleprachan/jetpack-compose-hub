package app.prachang.composehub

import androidx.annotation.DrawableRes
import app.prachang.dummy_data.R

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
        val description: String? = null,
    )

    // Type of sample apps
    val demoApps = listOf(
        SampleApp(
            label = "Instagram",
            route = "instagram",
            icon = R.drawable.ic_instagram_icon,
            description = "Clone app of instagram. It is developed only for UI not for functionalities."
        ),
        SampleApp(
            label = "Gmail",
            route = "gmail",
            icon = R.drawable.ic_gmail,
            description = "Gmail sample app."
        ),
        SampleApp(
            label = "Facebook", route = "facebook", icon = R.drawable.ic_facebook,
            description = "Facebook sample app."
        ),
        SampleApp(
            label = "Tweeter",
            route = "facebook",
            icon = R.drawable.ic_tweeter,
            description = "Tweeter sample app",
        ),
    )

    val materialDesign = listOf(
        SampleApp(
            label = "App bar",
            route = "appbar",
            icon = R.drawable.ic_instagram_icon,
        ),
        SampleApp(
            label = "Bottom app bar",
            route = "bottomappbar",
            icon = R.drawable.ic_facebook
        ),
        SampleApp(
            label = "Buttons",
            route = "buttons",
            icon = R.drawable.ic_tweeter,
        ),
    )
}
