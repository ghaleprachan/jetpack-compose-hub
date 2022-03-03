package app.prachang.android_common.handlers

import app.prachang.android_common.apputils.ErrorState
import app.prachang.android_common.apputils.LoadResults

inline fun <T> doTryCatch(crossinline task: () -> LoadResults<T>): LoadResults<T> {
    return try {
        task.invoke()
    } catch (e: Exception) {
        ErrorState(message = e.message)
    }
}
