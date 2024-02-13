package skustra.ui.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import skustra.draft.databinding.FragmentDashboardBinding
import skustra.draft.databinding.FragmentOnboardingBinding

class DashBoardFragment : Fragment() {

    private val binding: FragmentDashboardBinding by lazy {
        FragmentDashboardBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root
}