package com.ranjith.enums

enum class ThemeType {
    LIGHT, DARK
}

package com.ranjith.themes

interface Theme {
    fun renderTheme()
}

package com.ranjith.themes

class DarkTheme: Theme {
    override fun renderTheme() {
        println("Rendering Dark Theme")
    }
}

package com.ranjith.themes

class LightTheme: Theme {
    override fun renderTheme() {
        println("Rendering Light Theme")
    }
}

package com.ranjith.buttons

interface Button {
    fun renderButton()
}

package com.ranjith.buttons

class DarkThemeButton: Button {
    override fun renderButton() {
        println("Rendering Dark Theme Button")
    }
}

package com.ranjith.buttons

class LightThemeButton: Button {
    override fun renderButton() {
        println("Rendering Light Theme Button")
    }
}

package com.ranjith.checkboxes

interface CheckBox {
    fun renderCheckBox()
}

package com.ranjith.checkboxes

class DarkThemeCheckBox: CheckBox {
    override fun renderCheckBox() {
        println("Rendering Dark Theme Button")
    }
}

package com.ranjith.checkboxes

class LightThemeCheckBox: CheckBox {
    override fun renderCheckBox() {
        println("Rendering Light Theme Button")
    }
}

package com.ranjith.themefactory

import com.ranjith.buttons.Button
import com.ranjith.checkboxes.CheckBox
import com.ranjith.themes.Theme

interface ThemeFactory {
    fun createTheme(): Theme
    fun createButton(): Button
    fun createCheckBox(): CheckBox
}

package com.ranjith.themefactory

import com.ranjith.buttons.Button
import com.ranjith.buttons.LightThemeButton
import com.ranjith.checkboxes.CheckBox
import com.ranjith.checkboxes.LightThemeCheckBox
import com.ranjith.themes.LightTheme
import com.ranjith.themes.Theme

class LightThemeFactory: ThemeFactory {
    override fun createTheme(): Theme {
        return LightTheme()
    }

    override fun createButton(): Button {
        return LightThemeButton()
    }

    override fun createCheckBox(): CheckBox {
        return LightThemeCheckBox()
    }
}

package com.ranjith.themefactory

import com.ranjith.buttons.Button
import com.ranjith.buttons.DarkThemeButton
import com.ranjith.checkboxes.CheckBox
import com.ranjith.checkboxes.DarkThemeCheckBox
import com.ranjith.themes.DarkTheme
import com.ranjith.themes.Theme

class DarkThemeFactory: ThemeFactory {
    override fun createTheme(): Theme {
        return DarkTheme()
    }

    override fun createButton(): Button {
        return DarkThemeButton()
    }

    override fun createCheckBox(): CheckBox {
        return DarkThemeCheckBox()
    }
}

//Client
package com.ranjith.service

import com.ranjith.enums.ThemeType
import com.ranjith.themefactory.DarkThemeFactory
import com.ranjith.themefactory.LightThemeFactory
import com.ranjith.themes.DarkTheme
import com.ranjith.themes.Theme
import org.springframework.stereotype.Service

@Service
class UIComponentService {
    fun renderTheme(themeType: ThemeType) {
        val themeFactory = when(themeType) {
            ThemeType.LIGHT -> LightThemeFactory()
            ThemeType.DARK -> DarkThemeFactory()
            else -> throw IllegalArgumentException("Invalid Theme Type")
        }
        themeFactory.createTheme().renderTheme()
        themeFactory.createButton().renderButton()
        themeFactory.createCheckBox().renderCheckBox()
    }
}
