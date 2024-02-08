package skustra

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import skustra.dark.di.appModule
import skustra.dark.domain.usecase.theme.ThemeRepository
import skustra.draft.ui.feautres.theme.ApplicationThemeController

class DraftApplication : Application() {

    private val themeRepository: ThemeRepository by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DraftApplication)
            modules(appModule)
        }

        CoroutineScope(Dispatchers.Main).launch {
            setDayNightMode()
            setColorTheme()
            ApplicationThemeController.initialize(this@DraftApplication)
        }
    }

    private suspend fun setDayNightMode() {
        val themeMode = when (themeRepository.isDarkModeApplied()) {
            null -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            true -> AppCompatDelegate.MODE_NIGHT_YES
            false -> AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(themeMode)
    }

    private suspend fun setColorTheme() {
        val colorTheme = themeRepository.getColorTheme()
        ApplicationThemeController.applyColorTheme(colorTheme)
    }
}