package com.ranjith.pizzas

interface Pizza {
    fun preparePizza()
}

package com.ranjith.pizzas

class PlainPizza: Pizza {
    override fun preparePizza() {
        println("Preparing PlainPizza")
    }
}

package com.ranjith.pizzas

class CheeseDecorator(private val basePizza: Pizza): Pizza {
    override fun preparePizza() {
        basePizza.preparePizza()
        println("Adding Cheese")
    }
}

package com.ranjith.pizzas

class PepperoniDecorator(private val basePizza: Pizza): Pizza {
    override fun preparePizza() {
        basePizza.preparePizza()
        println("Adding Pepperoni")
    }
}

package com.ranjith.service

import com.ranjith.pizzas.CheeseDecorator
import com.ranjith.pizzas.OlivesDecorator
import com.ranjith.pizzas.PepperoniDecorator
import com.ranjith.pizzas.PlainPizza
import org.springframework.stereotype.Service

@Service
class PizzaService {
    fun pizzaManager() {
        println("Plain Pizza:")
        val plainPizza = PlainPizza()
        plainPizza.preparePizza()

        println("Cheese Pizza:")
        val cheesePizza =  CheeseDecorator(PlainPizza())
        cheesePizza.preparePizza()

        println("Cheese and Pepperoni Pizza:")
        val cheeseAndPepperoniPizza = CheeseDecorator(PepperoniDecorator(PlainPizza()))
        cheeseAndPepperoniPizza.preparePizza()

        println("Cheese, Pepperoni and Olives Pizza:")
        val cheesePepperoniAndOlivesPizza = CheeseDecorator(PepperoniDecorator(OlivesDecorator(PlainPizza())))
        cheesePepperoniAndOlivesPizza.preparePizza()

        println("Pepperoni and Olives Pizza:")
        val pepperoniAndOlivesPizza = PepperoniDecorator(OlivesDecorator(PlainPizza()))
        pepperoniAndOlivesPizza.preparePizza()
    }
}
