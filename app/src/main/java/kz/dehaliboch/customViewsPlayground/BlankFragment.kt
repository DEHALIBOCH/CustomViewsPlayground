package kz.dehaliboch.customViewsPlayground

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kz.dehaliboch.core.ui.base.BaseFragment
import kz.dehaliboch.customViewsPlayground.databinding.FragmentBlankBinding
import kz.dehaliboch.customviews.own_text_view.OwnCustomView

class BlankFragment : BaseFragment<FragmentBlankBinding>(R.layout.fragment_blank) {

    override fun inflateBinding(layoutInflater: LayoutInflater, container: ViewGroup?): FragmentBlankBinding {
        return FragmentBlankBinding.inflate(layoutInflater, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        val linearLayout = LinearLayout(requireContext())
        linearLayout.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val ownCustomView = OwnCustomView(requireContext(), null)
        ownCustomView.setFillColor(Color.GREEN)
        linearLayout.addView(ownCustomView)
        return linearLayout
    }

}