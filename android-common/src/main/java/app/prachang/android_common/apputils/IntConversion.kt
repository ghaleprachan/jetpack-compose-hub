package app.prachang.android_common.apputils

import kotlin.math.abs


fun likeConversion(number: Int): String {
    return if (abs(number / 1000000) > 1) {
        (number / 1000000).toString() + "m"
    } else if (abs(number / 1000) > 1) {
        (number / 1000).toString() + "k"
    } else {
        number.toString()
    }
}