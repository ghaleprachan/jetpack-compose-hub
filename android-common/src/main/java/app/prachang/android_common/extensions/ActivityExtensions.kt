package app.prachang.android_common.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment

inline fun <reified T : Context> Context.baseContext(): T? {
    var context: Context? = this
    do {
        if (context is T) {
            return context
        }
        if (context is ContextWrapper) {
            context = context.baseContext
        }
    } while (context != null)
    return null
}

fun Activity.hideKeyboard() {
    val imm: InputMethodManager? = getSystemService()
    val currentFocus = currentFocus
    if (currentFocus != null && imm != null) {
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }
}

fun Fragment.hideKeyboard() = requireActivity().hideKeyboard()

