package app.prachang.android_common.extensions

import kotlin.math.abs


fun Int.likeConversion(): String {
    return if (abs(this / 1000000) > 1) {
        "${this / 1000000}m"
    } else if (abs(this / 1000) > 1) {
        "${this / 1000}k"
    } else {
        this.toString()
    }
}