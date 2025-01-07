interface MealPreparationTemplate {
    fun prepareMeal() {
        procureIngredients()
        cook()
        garnish()
        serve()
    }

    fun procureIngredients()
    fun cook()
    fun garnish() {
        println("Garnishing the meal")
    }
    private fun serve() {
        println("Serving the meal")
    }
}

class NonVegMealPreparation: MealPreparationTemplate {
    override fun procureIngredients() {
        println("Procure meat")
    }

    override fun cook() {
        println("Cooking meat")
    }
}

class VegMealPreparation: MealPreparationTemplate {
    override fun procureIngredients() {
        println("Procure vegetables")
    }

    override fun cook(){
        println("Cooking vegetables")
    }
}

@Service
class MealsPreparationService {

    fun prepareNonVegMeal() {
        val nonVegMeal = NonVegMealPreparation()
        nonVegMeal.prepareMeal()
    }

    fun prepareVegMeal() {
        val vegMeal = VegMealPreparation()
        vegMeal.prepareMeal()
    }
}
