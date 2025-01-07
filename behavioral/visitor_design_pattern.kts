class Sales(
    var revenue: Long,
    var qtySold: Long,
    var profit: Long,
    var marginPerProduct: Long
) {
    fun generateReport(reportGenerator: ReportGeneratorVisitor) {
        reportGenerator.generateReport(this)
    }
}

class Employee(
    var name: String,
    var salary: Long,
    var department: String
) {
    fun generateReport(reportGenerator: ReportGeneratorVisitor) {
        reportGenerator.generateReport(this)
    }
}

interface ReportGeneratorVisitor {
    fun generateReport(sales: Sales)
    fun generateReport(employee: Employee)
}

class PDFReportGenerator: ReportGeneratorVisitor {
    override fun generateReport(sales: Sales) {
        println("Generating PDF Report for sales data")
    }

    override fun generateReport(employee: Employee) {
        println("Generating PDF Report for employee data")
    }
}

class CSVReportGenerator: ReportGeneratorVisitor {
    override fun generateReport(sales: Sales) {
        println("Generating CSV Report for sales data.")
    }

    override fun generateReport(employee: Employee) {
        println("Generating CSV Report for employee data.")
    }
}

//Client
@Service
class ReportGeneratorService {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(ReportGeneratorService::class.java)
    }

    fun getPDFReports() {
        log.info("Generating PDF report")
        val sales = Sales(1000, 100, 500, 5)
        val employee = Employee("John", 10000, "Engineering")
        val pdfReportGenerator = PDFReportGenerator()
        salesDTO.generateReport(pdfReportGenerator)
        employeeDTO.generateReport(pdfReportGenerator)
    }

    fun getCSVReports() {
        log.info("Generating CSV report")
        val sales = Sales(1000, 100, 500, 5)
        val employee = Employee("John", 10000, "Engineering")
        val csvReportGenerator = CSVReportGenerator()
        salesDTO.generateReport(csvReportGenerator)
        employeeDTO.generateReport(csvReportGenerator)
    }

    //You can generate more Reports just by adding new ReportGeneratorVisitor implementations without modifying Entities(Sales, Employee)
}
