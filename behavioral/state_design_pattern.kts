interface TicketStateHandler {
    fun currentStateInfo()
    fun processTicket(ticketDTO: TicketDTO)
    fun markTicketExpired(ticketDTO: TicketDTO)
}

class AvailableStateHandler: TicketStateHandler {
    override fun currentStateInfo() {
        println("Ticket is Available to be reserved.")
    }

    override fun processTicket(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.RESERVED
        ticketDTO.ticketStateHandler = ReservedStateHandler()
        println("Ticket is Reserved.")
    }

    override fun markTicketExpired(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.EXPIRED
        ticketDTO.ticketStateHandler = ExpiredStateHandler()
        println("Ticket is Expired.")
    }
}

class ReservedStateHandler: TicketStateHandler {
    override fun currentStateInfo() {
        println("Ticket is Reserved to be booked")
    }

    override fun processTicket(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.BOOKED
        ticketDTO.ticketStateHandler = BookedStateHandler()
        println("Ticket is Booked.")
    }

    fun releaseTicket(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.AVAILABLE
        ticketDTO.ticketStateHandler = AvailableStateHandler()
        println("Ticket is released.")
    }

    override fun markTicketExpired(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.EXPIRED
        ticketDTO.ticketStateHandler = ExpiredStateHandler()
        println("Ticket is Expired.")
    }
}

class BookedStateHandler: TicketStateHandler {
    override fun currentStateInfo() {
        println("Ticket is Booked.")
    }

    override fun processTicket(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.UTILIZED
        ticketDTO.ticketStateHandler = UtilizedStateHandler()
        println("Ticket is Utilised")
    }

    fun cancelTicket(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.CANCELLED
        ticketDTO.ticketStateHandler = CancelledTicketHandler()
        println("Ticket is Cancelled.")
    }

    override fun markTicketExpired(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.EXPIRED
        ticketDTO.ticketStateHandler = ExpiredStateHandler()
        println("Ticket is Expired.")
    }
}

class UtilizedStateHandler: TicketStateHandler {
    override fun currentStateInfo() {
        println("Ticket is Utilized.")
    }

    override fun processTicket(ticketDTO: TicketDTO) {
        println("Hope you had a great time.")
    }

    override fun markTicketExpired(ticketDTO: TicketDTO) {
        println("Ticket is Utilized, so can't be Expired.")
    }
}

class CancelledTicketHandler: TicketStateHandler {
    override fun currentStateInfo() {
        println("Ticket is Cancelled.")
    }

    override fun processTicket(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.AVAILABLE
        ticketDTO.ticketStateHandler = AvailableStateHandler()
        println("Ticket is Available to be booked.")
    }

    override fun markTicketExpired(ticketDTO: TicketDTO) {
        ticketDTO.state = TicketState.EXPIRED
        ticketDTO.ticketStateHandler = ExpiredStateHandler()
        println("Ticket is Expired.")
    }
}

class ExpiredStateHandler: TicketStateHandler {
    override fun currentStateInfo() {
        println("Ticket is Expired.")
    }

    override fun processTicket(ticketDTO: TicketDTO) {
        println("Ticket has Expired already")
    }

    override fun markTicketExpired(ticketDTO: TicketDTO) {
        println("Ticket has Expired already.")
    }
}

data class TicketDTO (
    var state: TicketState = TicketState.AVAILABLE,
    var ticketStateHandler: TicketStateHandler = AvailableStateHandler()
)

@Service
class TicketBookingService {

    fun processTicketBooking() {
        val ticketDTO = TicketDTO()
        ticketDTO.ticketStateHandler.currentStateInfo()
        ticketDTO.ticketStateHandler.processTicket(ticketDTO)

        ticketDTO.ticketStateHandler.currentStateInfo()
        ticketDTO.ticketStateHandler.processTicket(ticketDTO)

        ticketDTO.ticketStateHandler.currentStateInfo()
        ticketDTO.ticketStateHandler.processTicket(ticketDTO)

        ticketDTO.ticketStateHandler.currentStateInfo()
        ticketDTO.ticketStateHandler.processTicket(ticketDTO)
    }
}
