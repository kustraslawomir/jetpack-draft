package skustra.draft.ui.feautres.theme

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import com.google.android.material.color.DynamicColors
import skustra.dark.common.theme.ApplicationColorTheme
import skustra.draft.R
import java.util.*

object ApplicationThemeController {

    private val activities = Collections.newSetFromMap(WeakHashMap<Activity, Boolean>())
    private var initialized = false

    var colorTheme: ApplicationColorTheme = ApplicationColorTheme.Default

    fun initialize(application: Application) {
        if (!initialized) {
            initialized = true
            application.registerActivityLifecycleCallbacks(ActivityCallbacks())
        }
    }

    fun applyColorTheme(colorTheme: ApplicationColorTheme) {
        this.colorTheme = colorTheme
        activities.forEach(ActivityCompat::recreate)
    }

    fun switchToDarkMode(enableDarkMode: Boolean) {
        if (enableDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private class ActivityCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            when (colorTheme) {
                ApplicationColorTheme.Dynamic -> DynamicColors.applyIfAvailable(activity)
                ApplicationColorTheme.Orange -> {
                    activity.theme.applyStyle(R.style.ColorThemeOverlay_Orange, true)
                }

                else -> {
                    //do nothing
                }
            }
            activities.add(activity)
        }

        override fun onActivityDestroyed(activity: Activity) {
            activities.remove(activity)
        }

        override fun onActivityStarted(activity: Activity) {
        }

        override fun onActivityResumed(activity: Activity) {
        }

        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }
    }
}