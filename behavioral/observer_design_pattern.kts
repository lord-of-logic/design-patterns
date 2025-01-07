abstract class Investor(var name: String) {
    abstract fun takeAction(updatedPrice: Long, stockName: String)
}

class RetailInvestor(name: String): Investor(name) {
    override fun takeAction(updatedPrice: Long, stockName: String) {
        println("Retail Investor taking action on $stockName based on updated price: $updatedPrice")
    }
}

class HedgeFundInvestor(name: String): Investor(name) {
    override fun takeAction(updatedPrice: Long, stockName: String) {
        println("Hedge fund Investor taking action on $stockName based on updated price: $updatedPrice")
    }
}

class InstitutionalInvestor(name: String): Investor(name) {
    override fun takeAction(updatedPrice: Long, stockName: String) {
        println("Institutional Investor taking action on $stockName based on updated price: $updatedPrice")
    }
}

class StockExchange(
    private val investors: MutableList<Investor> = mutableListOf()
) {
    fun addInvestor(investor: Investor) {
        this.investors.add(investor)
    }

    fun removeInvestor(investor: Investor) {
        this.investors.remove(investor)
    }

    fun notifyUpdatedPriceToInvestors(updatedPrice: Long, stockName: String) {
        investors.forEach {
            it.takeAction(updatedPrice, stockName)
        }
    }
}

//Client
@Service
class StockExchangeService {
    fun updateStockPrice() {
        val stockExchange = StockExchange()
        stockExchange.addInvestor(RetailInvestor("Ranjith"))
        val deShawFund = HedgeFundInvestor("DE Shaw")
        stockExchange.addInvestor(deShawFund)
        stockExchange.addInvestor(InstitutionalInvestor("Goldman Sachs"))
        stockExchange.notifyUpdatedPriceToInvestors(150, "GOOGL")
        stockExchange.removeInvestor(deShawFund)
        stockExchange.notifyUpdatedPriceToInvestors(200, "GOOGL")
    }
}
