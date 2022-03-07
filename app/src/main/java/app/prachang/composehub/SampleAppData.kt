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
            route = Routes.Material.AppBar,
        ),
        SampleApp(
            label = "Bottom app bar",
            route = "bottomappbar",
        ),
        SampleApp(
            label = "Buttons",
            route = "buttons",
        ),
    )

    // Types of material design you
    private val materialDesign3 = listOf(
        SampleApp(
            label = "Appbar",
            route = Routes.Material3.AppBar,
        ),
        SampleApp(
            label = "Bottom Appbar", route = Routes.Material3.BottomBar,
        ),
        SampleApp(
            label = "Text & Buttons",
            route = Routes.Material3.TextButtons,
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
            label = "Material Design 3",
            route = Routes.Animation,
            icon = R.drawable.ic_material_design_you,
            subSamples = materialDesign3
        ),
        SampleApp(
            label = "Material Design",
            route = Routes.Animation,
            icon = R.drawable.ic_material_design,
            subSamples = materialDesign
        ),
        SampleApp(
            label = "Animations",
            route = Routes.Animation,
            icon = R.drawable.ic_animations,
        ),
    )

    data class SampleApp(
        val label: String,
        val route: String? = null,
        @DrawableRes val icon: Int = -1,
        val description: String? = null,
        val subSamples: List<SampleApp> = emptyList()
    )
}
