package com.ranjith.payments

interface OfflinePayment {
    fun acceptPayment()
}

package com.ranjith.payments

class CashPayment(private val amountToPay: Double): OfflinePayment {
    override fun acceptPayment() {
        println("Accepting $amountToPay cash payment")
    }
}

package com.ranjith.payments

interface DigitalPayment {
    fun acceptPaymentDigitally()
}

package com.ranjith.payments

class CryptoPayment(private val amountToPay: String): DigitalPayment {
    override fun acceptPaymentDigitally() {
        println("Accepting $amountToPay crypto payment")
    }
}

package com.ranjith.payments

class DigitalPaymentAdapter(private val digitalPayment: DigitalPayment): OfflinePayment {
    override fun acceptPayment() {
        digitalPayment.acceptPaymentDigitally()
    }
}

//Client
package com.ranjith.service

import com.ranjith.payments.CashPayment
import com.ranjith.payments.CryptoPayment
import com.ranjith.payments.DigitalPaymentAdapter

class PaymentService {
    fun payBill() {
        val paymentTypeObject = CashPayment(50.0)
        paymentTypeObject.acceptPayment()

        val digitalPaymentObject = CryptoPayment("45.0")
        //digitalPaymentObject.acceptPayment() -> Can't be used as it is not compatible

        val digitalPaymentAdapter = DigitalPaymentAdapter(CryptoPayment("45.0"))
        digitalPaymentAdapter.acceptPayment()
    }
}
