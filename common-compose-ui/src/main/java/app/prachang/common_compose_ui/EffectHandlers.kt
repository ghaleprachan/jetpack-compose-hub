package app.prachang.common_compose_ui

import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch

@Composable
fun LaunchEffectSample() {
    val text by remember {
        mutableStateOf("")
    }
    LaunchedEffect(key1 = text, block = {
        delay(1000)
        print("Hello world $text")
    })
}

@Composable
fun RememberCoroutineScope() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000)
            print("Hello world!")
        }
    }) {
        Text(text = "Click here")
    }
}

@Composable
fun DisposableEffectSample() {
    val context = LocalContext.current
    val lifeCycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifeCycleOwner) {
        // LifeCycle Event Observer
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                Toast.makeText(context, "On Pause", Toast.LENGTH_SHORT).show()
            }
        }
        // Add Lifecycle Observer to LifeCycleOwner
        lifeCycleOwner.lifecycle.addObserver(observer)

        onDispose {
            // Remove LifeCycle Observer to precent leaks
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

// produceState gives coroutine scope
// We can change state over time using this scope.
@Composable
fun produceStateDemo(countUpTo: Int): State<Int> {
    return produceState(
        initialValue = 0,
        producer = {
            delay(2000)
            value++
        },
    )
}

@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }
    val counterText by derivedStateOf {
        "The counter is $counter"
    }

    Button(onClick = {
        counter++
    }) {
        Text(text = counterText)
    }
}

@Composable
fun SnapFlowDemo() {
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = scaffoldState, block = {
        snapshotFlow { scaffoldState.snackbarHostState }.mapNotNull { it.currentSnackbarData?.message }
            .distinctUntilChanged().collect {
                print("A snackbar with message $it was shown.")
            }
    })
}

@Composable
fun SideEffectSample(nonComposeCounter: Int) {
    // Side effect gets called when composable successfully re-compose
    SideEffect {
        print("Called after successful re-composition")
    }
}