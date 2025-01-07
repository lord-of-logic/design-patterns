class InterfaceClassFactory {

    fun returnInterfaceClassType(inputClassName: String): InterfaceClass? {
        return when (inputClassName) {
            "DerivedClass1" -> DerivedClass1()
            "DerivedClass2" -> DerivedClass2()
            else -> null
        }
    }
}

interface InterfaceClass {
    fun doSomething()
}

class DerivedClass1: InterfaceClass {

    override fun doSomething() {
        println("DerivedClass1 is doing something")
    }
}

class DerivedClass2: InterfaceClass {
    override fun doSomething() {
        println("DerivedClass2 is doing something")
    }
}

fun main() {
    val derivedClass1 = InterfaceClassFactory().returnInterfaceClassType("DerivedClass1")
    val derivedClass2 = InterfaceClassFactory().returnInterfaceClassType("DerivedClass2")
    derivedClass1!!.doSomething()
    derivedClass2!!.doSomething()
}
