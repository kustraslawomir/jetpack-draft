package skustra.ui.fragments.theme

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.color.DynamicColors
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import skustra.dark.domain.usecase.theme.ThemeColorScheme
import skustra.dark.domain.usecase.theme.ThemePreferences
import skustra.draft.databinding.FragmentCustomThemeBinding

class CustomizeThemeFragment : Fragment() {


    private val binding: FragmentCustomThemeBinding by lazy {
        FragmentCustomThemeBinding.inflate(layoutInflater)
    }

    private val themePreferences: ThemePreferences by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeColorThemeSelection()
        observeThemeModeSelection()
        setColorThemeToggles()
        setThemeModeToggles()
    }

    private fun observeThemeModeSelection() {
        binding.optionNight.setOnCheckedChangeListener { _, isChecked ->
            lifecycleScope.launch {
                ApplicationThemeController.switchToDarkMode(enableDarkMode = isChecked)
                themePreferences.setDarkModeApplied(isChecked)
            }
        }
    }

    private fun observeColorThemeSelection() {
        val onCheckedChanged = CompoundButton.OnCheckedChangeListener { view, isChecked ->
            if (!isChecked) return@OnCheckedChangeListener
            when (view) {
                binding.optionDefaultTheme -> setColorTheme(ThemeColorScheme.Default)
                binding.optionDynamicTheme -> setColorTheme(ThemeColorScheme.Dynamic)
                binding.optionOrangeTheme -> setColorTheme(ThemeColorScheme.Orange)
            }
        }

        binding.apply {
            optionDynamicTheme.setOnCheckedChangeListener(onCheckedChanged)
            optionDefaultTheme.setOnCheckedChangeListener(onCheckedChanged)
            optionOrangeTheme.setOnCheckedChangeListener(onCheckedChanged)
        }
    }

    private fun setColorTheme(colorTheme: ThemeColorScheme) {
        lifecycleScope.launch {
            if (ApplicationThemeController.colorTheme == colorTheme) return@launch
            themePreferences.setColorTheme(colorTheme)
            ApplicationThemeController.applyColorTheme(colorTheme)
        }
    }

    private fun setColorThemeToggles() {
        val currentTheme = requireNotNull(ApplicationThemeController.colorTheme)
        val defaultThemeSelected = currentTheme == ThemeColorScheme.Default
        val dynamicThemeSelected = currentTheme == ThemeColorScheme.Dynamic
        val orangeThemeSelected = currentTheme == ThemeColorScheme.Orange

        binding.apply {
            optionDefaultTheme.isChecked = defaultThemeSelected
            optionDynamicTheme.isChecked = dynamicThemeSelected
            optionOrangeTheme.isChecked = orangeThemeSelected
            optionDynamicTheme.isVisible = DynamicColors.isDynamicColorAvailable()
        }
    }

    private fun setThemeModeToggles() {
        val darkModeApplied =
            resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        if (darkModeApplied) {
            binding.optionDay.isChecked = false
            binding.optionNight.isChecked = true
        } else {
            binding.optionDay.isChecked = true
            binding.optionNight.isChecked = false
        }
    }
}