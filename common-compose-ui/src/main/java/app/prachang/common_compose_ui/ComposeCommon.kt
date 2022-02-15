package app.prachang.common_compose_ui

import android.content.Context
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// val context: Context @Composable get() = LocalContext.current
/*@Composable
fun getContext(): Context {
    return LocalContext.current
}*/

/*val context: Context
    @Composable get() {
        return LocalContext.current
    }*/

val context
    @Composable
    get() = LocalContext.current

/*
val context: @Composable () -> Context = {
    LocalContext.current
}


val context*/
