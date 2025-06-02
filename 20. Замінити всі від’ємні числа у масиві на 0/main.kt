val numbers = arrayOf(5, -3, 8, -1, 0, 4)
val result = numbers.map { if (it < 0) 0 else it }.toTypedArray()
println("Modified array: ${result.joinToString()}")
