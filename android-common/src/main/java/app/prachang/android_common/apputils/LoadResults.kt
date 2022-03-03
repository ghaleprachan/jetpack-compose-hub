package app.prachang.android_common.apputils

/**
 * This is to handle different state during API calls.
 - Here [data] is received on success response
 - Here [message] is referred as error message
 * */
sealed class LoadResults<T>(
    val data: T? = null,
    val message: String? = null
)

class LoadingState<T> : LoadResults<T>()
class SuccessState<T>(data: T) : LoadResults<T>(data = data)
class ErrorState<T>(message: String?) : LoadResults<T>(message = message)
