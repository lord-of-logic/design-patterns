interface TravelStrategy {
    fun travel()
}

class TravelByShip: TravelStrategy {
    override fun travel() {
        println("Travelling By Ship")
    }
}

class TravelByPlane: TravelStrategy {
    override fun travel() {
        println("Travelling By Plane")
    }
}

class TravelStrategyProcessor(
    private var travelStrategy: TravelStrategy
) {

    fun setTravelStrategy(newTravelStrategy: TravelStrategy) {
        travelStrategy = newTravelStrategy
    }

    fun travel() {
        travelStrategy.travel()
    }
}

//Client
@Service
class TravelService {

    fun travel() {
        val travelStrategyProcessor = TravelStrategyProcessor(TravelByPlane())
        travelStrategyProcessor.travel()

        travelStrategyProcessor.setTravelStrategy(TravelByShip())
        travelStrategyProcessor.travel()
    }
}
