package app.prachang.common_compose_ui.utils

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun LifecycleEventObserver(
    onPause: () -> Unit = {},
    onResume: () -> Unit = {},
    onStart: () -> Unit = {},
    onDestroy: () -> Unit = {},
) {
    val context = LocalContext.current
    val lifeCycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifeCycleOwner) {
        // LifeCycle Event Observer
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> onPause()

                Lifecycle.Event.ON_RESUME -> onResume()

                Lifecycle.Event.ON_START -> onStart()

                Lifecycle.Event.ON_DESTROY -> onDestroy()

                else -> {}
            }
        }
        // Add Lifecycle Observer to LifeCycleOwner
        lifeCycleOwner.lifecycle.addObserver(observer)

        onDispose {
            // Remove LifeCycle Observer to prevent leaks
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
