package app.prachang.android_common.apputils

sealed class LoadResults<T>(
    val data: T? = null,
    val message: String? = null
)

class LoadingState<T> : LoadResults<T>()
class SuccessState<T>(data: T) : LoadResults<T>(data = data)
class ErrorState<T>(message: String?) : LoadResults<T>(message = message)
