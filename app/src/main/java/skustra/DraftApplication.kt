package skustra

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import skustra.draft.ui.feautres.theme.ColorTheme
import skustra.draft.ui.feautres.theme.ColorThemesController
import skustra.draft.ui.feautres.theme.ThemesStorage

class DraftApplication : Application() {

    private lateinit var themesStorage: ThemesStorage

    override fun onCreate() {
        super.onCreate()
        themesStorage = ThemesStorage(this)

        setDayNightMode()
        setColorTheme()

        ColorThemesController.initialize(this)
    }

    private fun setDayNightMode() {
        val themeMode = when (themesStorage.isDarkModeApplied()) {
            null -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            true -> AppCompatDelegate.MODE_NIGHT_YES
            false -> AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(themeMode)
    }

    private fun setColorTheme() {
        val colorTheme = themesStorage.getColorTheme() ?: ColorTheme.DEFAULT
        ColorThemesController.applyColorTheme(colorTheme)
    }
}