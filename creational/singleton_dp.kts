class SingletonClass private constructor() {
    companion object{
        private var singletonClass: SingletonClass? = null
        private var numOfInstances = 0

        @Synchronized
        fun getSingletonObject(): SingletonClass {
            if (singletonClass == null){
                singletonClass = SingletonClass()
                numOfInstances++
            }
            return singletonClass as SingletonClass
        }
    }

    fun doSomething() {
        println("SingletonClass is doing something $numOfInstances")
    }
}

fun main() {
    val singletonClassObject1 = SingletonClass.getSingletonObject()
    singletonClassObject1.doSomething()
    val singletonClassObject2 = SingletonClass.getSingletonObject()
    singletonClassObject2.doSomething()
}
