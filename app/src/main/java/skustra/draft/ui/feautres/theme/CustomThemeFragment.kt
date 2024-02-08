package skustra.draft.ui.feautres.theme

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.color.DynamicColors
import skustra.draft.databinding.FragmentCustomThemeBinding

class CustomThemeFragment : Fragment() {

    private val themesStorage: ThemesStorage by lazy {
        ThemesStorage(requireContext())
    }

    private val binding: FragmentCustomThemeBinding by lazy {
        FragmentCustomThemeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setColorThemeToggles()
        observeColorThemeSelection()
        setThemeModeToggles()
        observeThemeModeSelection()
    }

    private fun setColorThemeToggles() {
        val currentTheme = requireNotNull(ColorThemesController.colorTheme)
        val defaultThemeSelected = currentTheme == ColorTheme.DEFAULT
        val dynamicThemeSelected = currentTheme == ColorTheme.DYNAMIC
        val orangeThemeSelected = currentTheme == ColorTheme.ORANGE

        binding.apply {
            optionDefaultTheme.isChecked = defaultThemeSelected
            optionDynamicTheme.isChecked = dynamicThemeSelected
            optionOrangeTheme.isChecked = orangeThemeSelected
            optionDynamicTheme.isVisible = DynamicColors.isDynamicColorAvailable()
        }
    }

    private fun observeColorThemeSelection() {
        val onCheckedChanged = CompoundButton.OnCheckedChangeListener { view, isChecked ->
            if (!isChecked) return@OnCheckedChangeListener
            when (view) {
                binding.optionDefaultTheme -> setColorTheme(ColorTheme.DEFAULT)
                binding.optionDynamicTheme -> setColorTheme(ColorTheme.DYNAMIC)
                binding.optionOrangeTheme -> setColorTheme(ColorTheme.ORANGE)
            }
        }

        binding.apply {
            optionDynamicTheme.setOnCheckedChangeListener(onCheckedChanged)
            optionDefaultTheme.setOnCheckedChangeListener(onCheckedChanged)
            optionOrangeTheme.setOnCheckedChangeListener(onCheckedChanged)
        }
    }

    private fun setColorTheme(colorTheme: ColorTheme) {
        if (ColorThemesController.colorTheme == colorTheme) return
        themesStorage.setColorTheme(colorTheme)
        ColorThemesController.applyColorTheme(colorTheme)
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

    private fun observeThemeModeSelection() {
        binding.optionNight.setOnCheckedChangeListener { _, isChecked ->
            ApplicationTheme.toggleDarkTheme(isChecked)
            themesStorage.setDarkModeApplied(isChecked)
        }
    }
}