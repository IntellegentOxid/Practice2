val inputs = listOf("10", "abc", "25", "7.5", "-3")
val numbers = inputs.map {
    try {
        it.toInt()
    } catch (e: NumberFormatException) {
        0
    }
}
println("Parsed numbers: $numbers")
