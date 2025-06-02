fun greetUser(name: String?) {
    val finalName = if (name.isNullOrBlank()) "Anonymous" else name
    println("Hello, $finalName")
}
