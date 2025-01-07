class Order(
    id: String,
    customerId: String,
    orderDate: String,
    expectedDeliveryDate: String,
    deliveryMode: String,
    status: String
) {
    var id: String? = null
    var customerId: String? = null
    var orderDate: String? = null
    var expectedDeliveryDate: String? = null
    var deliveryMode: String? = null
    var status: String? = null
}

class OrderItems(order: Order, itemName: String, quantity: String, price: String) {
    var order: Order? = null
//vs
//    var customerId: String? = null
//    var orderDate: String? = null
//    var expectedDeliveryDate: String? = null
//    var deliveryMode: String? = null
    var itemName: String? = null
    var quantity: String? = null
    var price: String? = null
}

fun main() {
    val order = Order(
        "Order_1",
        "Customer_1",
        "23/09/2003",
        "29/10/2024",
        "Air",
        "Delivered"
    )
    val orderItem1 = OrderItems(
        order,
        "OrderItem_1",
        "2",
        "10000"
    )
    val orderItem2 = OrderItems(
        order,
        "OrderItem_2",
        "2",
        "10000"
    )
}
