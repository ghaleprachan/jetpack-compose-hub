package app.prachang.android_common.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import app.prachang.android_common.extensions.hideKeyboard

abstract class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideKeyboard()
    }
}