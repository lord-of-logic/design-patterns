//Implementor
interface UtensilType {
    fun doAction()
}

//Concrete Implementor
class Spoon: UtensilType {
    private var utensilName: String = "Spoon"
    private var utensilMaterial: String = "Steel"
    override fun doAction() {
        println("tasted using $utensilName made up of $utensilMaterial")
    }
}

class Plate: UtensilType {
    private var utensilName: String = "Plate"
    private var utensilMaterial: String = "Silver"
    override fun doAction() {
        println("eaten using $utensilName made up of $utensilMaterial")
    }
}

class Glass: UtensilType {
    private var utensilName: String = "Glass"
    private var utensilMaterial: String = "Plastic"
    override fun doAction() {
        println("drunk using $utensilName made up of $utensilMaterial")
    }
}

//Abstracter
abstract class FoodItem(var utensilType: UtensilType) {
    abstract fun printFoodItemAndMode()
}

//Refined Abstracter
class Water(utensilType: UtensilType) : FoodItem(utensilType) {
    private var itemName: String = "Water"
    private var itemTaste: String = "None"
    override fun printFoodItemAndMode() {
        println("$itemName was ")
        utensilType.doAction()
    }
}

class GulabJamun(utensilType: UtensilType): FoodItem(utensilType) {
    private var itemName: String = "GulabJamun"
    private var itemTaste: String = "Sweet"
    override fun printFoodItemAndMode() {
        println("$itemName was ")
        utensilType.doAction()
    }
}

fun main() {
    val foodItem1 = Water(Glass())
    foodItem1.printFoodItemAndMode()
    val foodItem2 = GulabJamun(Spoon())
    foodItem2.printFoodItemAndMode()
}
