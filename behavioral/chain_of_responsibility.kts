//Request Handler Interface
abstract class RequestHandler {
    private var nextRequestHandler: RequestHandler? = null

    fun setNextRequestHandler(handler: RequestHandler) {
        this.nextRequestHandler = handler
    }

    abstract fun handleRequest(request: Request)

    fun callNextRequestHandler(request: Request) {
        this.nextRequestHandler?.handleRequest(request)
    }
}

//Concrete Handler
class Level1RequestHandler: RequestHandler() {
    override fun handleRequest(request: Request) {
        if (request.inputRequest == "RequestLevel1") {
            println("Request handled by Level1")
        }
        else {
            println("Request can't be handled by Level1")
            callNextRequestHandler(request)
        }
    }
}

class Level2RequestHandler: RequestHandler() {
    override fun handleRequest(request: Request) {
        if (request.inputRequest == "RequestLevel2") {
            println("Request handled by Level2")
        }
        else {
            println("Request can't be handled by Level2")
            callNextRequestHandler(request)
        }
    }
}

class Level3RequestHandler: RequestHandler() {
    override fun handleRequest(request: Request) {
        if (request.inputRequest == "RequestLevel3") {
            println("Request handled by Level3")
        }
        else {
            println("Request can't be handled by Level3")
            println("Invalid Request")
        }
    }
}

//Request class
class Request(
    var inputRequest: String
)

//Client
fun main() {
    //Request Handlers
    val level1RequestHandler = Level1RequestHandler()
    val level2RequestHandler = Level2RequestHandler()
    val level3RequestHandler = Level3RequestHandler()

    // Request Handler Chain
    level1RequestHandler.setNextRequestHandler(level2RequestHandler)
    level2RequestHandler.setNextRequestHandler(level3RequestHandler)

    // Requests
    val request1 = Request("RequestLevel1")
    level1RequestHandler.handleRequest(request1)
    println("\n")
    val request2 = Request("RequestLevel2")
    level1RequestHandler.handleRequest(request2)
    println("\n")
    val request3 = Request("RequestLevel3")
    level1RequestHandler.handleRequest(request3)
    println("\n")
    val request4 = Request("RequestLevel4")
    level1RequestHandler.handleRequest(request4)
}
