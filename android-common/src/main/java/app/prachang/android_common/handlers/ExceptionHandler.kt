package app.prachang.android_common.handlers

import app.prachang.android_common.apputils.Error
import app.prachang.android_common.apputils.UiStates

inline fun <T> doTryCatch(crossinline task: () -> UiStates<T>): UiStates<T> {
    return try {
        task.invoke()
    } catch (e: Exception) {
        Error(message = e.message)
    }
}