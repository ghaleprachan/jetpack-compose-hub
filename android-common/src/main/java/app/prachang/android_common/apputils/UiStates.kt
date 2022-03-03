package app.prachang.android_common.apputils

sealed class UiStates<T>(
    val data: T? = null,
    val message: String? = null,
)

class Success<T>(data: T) : UiStates<T>(data)
class Loading<T> : UiStates<T>()
class Error<T>(message: String?) : UiStates<T>(message = message)