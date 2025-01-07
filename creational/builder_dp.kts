class Warehouse(
    private val id: String?,
    private val name: String?
) {
    class Builder{

        private var id: String? = null
        private var name: String? = null
        fun setId(id: String): Builder {
            this.id = id
            return this
        }
        fun setName(name: String): Builder {
            this.name = name
            return this
        }
        fun build() = Warehouse(this.id, this.name)
    }

    fun printDetails() {
        println("Warehouse details are ID: $id and name: $name")
    }
}

fun main() {
    val warehouse = Warehouse.Builder()
        .setName("Hyderabad Warehouse")
        .build()
    warehouse.printDetails()
}
