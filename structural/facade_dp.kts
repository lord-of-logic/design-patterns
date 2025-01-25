package com.ranjith.homeappliances

interface HomeAppliance {
    fun turnOn()
    fun turnOff()
}

package com.ranjith.homeappliances

import org.springframework.stereotype.Component

@Component
class AirConditioner: HomeAppliance {

    private var temperature: Int? = null

    override fun turnOn() {
        temperature = 25
        println("Air Conditioner is turned on")
    }

    fun setTemperature(temperature: Int) {
        println("Temperature is set to $temperature")
    }

    override fun turnOff() {
        println("Air Conditioner is turned off")
    }
}

package com.ranjith.homeappliances

import org.springframework.stereotype.Component

@Component
class WaterHeater: HomeAppliance {

    private var temperature: Int? = null

    override fun turnOn() {
        temperature = 60
        println("Water Heater is turned on")
    }

    fun setTemperature(temperature: Int) {
        println("Temperature is set to $temperature")
    }

    override fun turnOff() {
        println("Water Heater is turned off")
    }
}

package com.ranjith.homeappliances

import org.springframework.stereotype.Component

@Component
class TubeLights: HomeAppliance {

    private var brightness: Int? = null

    override fun turnOn() {
        brightness = 100
        println("Tube Lights are turned on")
    }

    fun setBrightness(brightness: Int) {
        println("Brightness is set to $brightness")
    }

    override fun turnOff() {
        println("Tube Lights are turned off")
    }
}

package com.ranjith.homeappliances

import com.ranjith.enums.LockEnum
import org.springframework.stereotype.Component

@Component
class MainDoorDigitalLock {

    private var lockStatus: LockEnum? = null

    fun unlock() {
        lockStatus = LockEnum.UNLOCKED
        println("Main Door is unlocked")
    }

    fun lock() {
        lockStatus = LockEnum.LOCKED
        println("Main Door is locked")
    }
}

package com.ranjith.enums

enum class LockEnum {
    LOCKED, UNLOCKED
}

package com.ranjith.homeappliances

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class HomeAppliancesFacade {
    @Autowired
    private lateinit var airConditioner: AirConditioner

    @Autowired
    private lateinit var tubeLights: TubeLights

    @Autowired
    private lateinit var waterHeater: WaterHeater

    @Autowired
    private lateinit var mainDoorDigitalLock: MainDoorDigitalLock

    fun enteringHome() {
        println("Welcome Home!")
        airConditioner.turnOn()
        tubeLights.turnOn()
        waterHeater.turnOn()
        mainDoorDigitalLock.unlock()
    }

    fun leavingHome() {
        println("Good Bye!")
        airConditioner.turnOff()
        tubeLights.turnOff()
        waterHeater.turnOff()
        mainDoorDigitalLock.lock()
    }
}

//Client
package com.ranjith.service

import com.ranjith.homeappliances.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HomeAppliancesService {
/*
    @Autowired
    private lateinit var airConditioner: AirConditioner

    @Autowired
    private lateinit var tubeLights: TubeLights

    @Autowired
    private lateinit var waterHeater: WaterHeater

    @Autowired
    private lateinit var mainDoorDigitalLock: MainDoorDigitalLock

 */

    @Autowired
    private lateinit var homeAppliancesFacade: HomeAppliancesFacade

    fun enteringHome() {
        /*
        val airConditioner = airConditioner.turnOn()
        val tubeLights = tubeLights.turnOn()
        val waterHeater = waterHeater.turnOn()
        val mainDoorDigitalLock = mainDoorDigitalLock.unlock()
        */
        homeAppliancesFacade.enteringHome()
    }

    fun leavingHome() {
        /*
        val airConditioner = airConditioner.turnOff()
        val tubeLights = tubeLights.turnOff()
        val waterHeater = waterHeater.turnOff()
        val mainDoorDigitalLock = mainDoorDigitalLock.lock()
        */
        homeAppliancesFacade.leavingHome()
    }
}
