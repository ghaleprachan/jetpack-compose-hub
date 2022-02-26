package app.prachang.composehub

import androidx.annotation.DrawableRes
import app.prachang.dummy_data.R

object SampleAppData {
    // Type of sample apps
    private val demoApps = listOf(
        SampleApp(
            label = "Instagram",
            route = Routes.Instagram,
            icon = R.drawable.ic_instagram_icon,
            description = "Clone app of instagram. It is developed only for UI not for functionalities."
        ),
        SampleApp(
            label = "Gmail",
            route = Routes.Gmail,
            icon = R.drawable.ic_gmail,
            description = "Gmail sample app."
        ),
        SampleApp(
            label = "Facebook",
            route = Routes.Facebook,
            icon = R.drawable.ic_facebook,
            description = "Facebook sample app."
        ),
        SampleApp(
            label = "Tweeter",
            route = Routes.Tweeter,
            icon = R.drawable.ic_tweeter,
            description = "Tweeter sample app",
        ),
    )

    // Type of material design
    private val materialDesign = listOf(
        SampleApp(
            label = "App bar",
            route = null,
            icon = R.drawable.ic_instagram_icon,
        ),
        SampleApp(
            label = "Bottom app bar", route = "bottomappbar", icon = R.drawable.ic_facebook
        ),
        SampleApp(
            label = "Buttons",
            route = "buttons",
            icon = R.drawable.ic_tweeter,
        ),
    )

    // Types of material design you
    private val materialDesign3 = listOf(
        SampleApp(
            label = "App bar",
            route = "appbar",
            icon = R.drawable.ic_instagram_icon,
        ),
        SampleApp(
            label = "Bottom app bar", route = "bottomappbar", icon = R.drawable.ic_facebook
        ),
        SampleApp(
            label = "Buttons",
            route = "buttons",
            icon = R.drawable.ic_tweeter,
        ),
    )

    val sampleApps = listOf(
        SampleApp(
            label = "Demo Apps",
            route = Routes.Dashboard,
            icon = R.drawable.ic_sample_apps,
            subSamples = demoApps,
        ),
        SampleApp(
            label = "Animations",
            route = Routes.Animation,
            icon = R.drawable.ic_animations,
        ),
        SampleApp(
            label = "Material Design",
            route = Routes.Animation,
            icon = R.drawable.ic_material_design,
            subSamples = materialDesign
        ),
        SampleApp(
            label = "Material Design",
            route = Routes.Animation,
            icon = R.drawable.ic_material_design_you,
            subSamples = materialDesign3
        ),
    )

    data class SampleApp(
        val label: String,
        val route: String? = null,
        @DrawableRes val icon: Int,
        val description: String? = null,
        val subSamples: List<SampleApp> = emptyList()
    )
}
