fun classifyTemperature(temp: Int) {
    val result = when {
        temp < 10 -> "Cold"
        temp in 10..25 -> "Normal"
        else -> "Hot"
    }
    println("Temperature: $temp°C — $result")
}

// Приклад виклику
classifyTemperature(5)
classifyTemperature(20)
classifyTemperature(30)
