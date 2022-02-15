package app.prachang.dummy_data

fun getRandomString(): String {
    return "Unless you've made a change to your Instagram bio, it will appear in Instagram's default font, Neue Helvetica. ".repeat(
        (1..6).random()
    )
}

fun getRandomInt(): Int {
    return (16..6000000).random()
}