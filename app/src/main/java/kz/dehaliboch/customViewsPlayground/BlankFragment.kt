package kz.dehaliboch.customViewsPlayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.dehaliboch.core.ui.base.BaseFragment
import kz.dehaliboch.customViewsPlayground.databinding.FragmentBlankBinding

class BlankFragment : BaseFragment<FragmentBlankBinding>(R.layout.fragment_blank) {

    override fun inflateBinding(layoutInflater: LayoutInflater, container: ViewGroup?): FragmentBlankBinding {
        return FragmentBlankBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}