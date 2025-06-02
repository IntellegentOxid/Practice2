import java.lang.Exception

class InvalidProductDataException(message: String) : Exception(message)

data class Purchase(val name: String?, val quantity: Int, val unitPrice: Double) {
    val totalPrice: Double
        get() = quantity * unitPrice
}

fun main() {
    val purchases = mutableListOf<Purchase>()

    var count: Int? = null
    while (count == null || count < 5) {
        print("Enter the number of purchases (at least 5): ")
        count = readLine()?.toIntOrNull()
        if (count == null || count < 5) {
            println("Please enter a number ≥ 5.")
        }
    }

    for (i in 1..count) {
        println("\nPurchase #$i")

        print("Product name (can be null): ")
        val name = readLine().takeIf { it?.isNotBlank() == true }

        print("Quantity: ")
        val quantity = readLine()?.toIntOrNull()
        if (quantity == null || quantity < 0) {
            throw InvalidProductDataException("Invalid quantity")
        }

        print("Unit price: ")
        val price = readLine()?.toDoubleOrNull()
        if (price == null || price < 0) {
            throw InvalidProductDataException("Invalid unit price")
        }

        purchases.add(Purchase(name, quantity, price))
    }

    val mostExpensive = purchases.maxByOrNull { it.totalPrice }
    val totalSum = purchases.sumOf { it.totalPrice }
    val expensiveCount = purchases.count { it.totalPrice > 1000 }

    println("\n=== Cash Report ===")
    purchases.forEachIndexed { index, purchase ->
        println("Purchase #${index + 1}: '${purchase.name ?: "Unnamed"}', Quantity: ${purchase.quantity}, Unit Price: ${purchase.unitPrice}, Total: ${purchase.totalPrice}")
    }

    println("\nMost expensive purchase: '${mostExpensive?.name ?: "Unnamed"}' with total ${mostExpensive?.totalPrice}")
    println("Total amount of all purchases: $totalSum UAH")
    println("Number of purchases over 1000 UAH: $expensiveCount")
}
