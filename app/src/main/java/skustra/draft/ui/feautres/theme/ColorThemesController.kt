package skustra.draft.ui.feautres.theme

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.material.color.DynamicColors
import skustra.draft.R
import java.util.*

object ColorThemesController {

    private val activities = Collections.newSetFromMap(WeakHashMap<Activity, Boolean>())
    private var initialized = false
    var colorTheme = ColorTheme.DEFAULT

    fun initialize(application: Application) {
        if (!initialized) {
            initialized = true
            application.registerActivityLifecycleCallbacks(ActivityCallbacks())
        }
    }

    fun applyColorTheme(colorTheme: ColorTheme) {
        this.colorTheme = colorTheme
        activities.forEach(ActivityCompat::recreate)
    }

    private class ActivityCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            when (colorTheme) {
                ColorTheme.DYNAMIC -> DynamicColors.applyIfAvailable(activity)
                ColorTheme.ORANGE -> {
                    activity.theme.applyStyle(R.style.ColorThemeOverlay_Orange, true)
                }
                else -> {
                    //do nothing
                }
            }
            activities.add(activity)
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

        override fun onActivityDestroyed(activity: Activity) {
            activities.remove(activity)
        }
    }
}