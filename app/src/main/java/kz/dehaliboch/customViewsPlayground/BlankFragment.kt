package kz.dehaliboch.customViewsPlayground

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kz.dehaliboch.core.ui.base.BaseFragment
import kz.dehaliboch.customViewsPlayground.databinding.FragmentBlankBinding
import kz.dehaliboch.customviews.OwnCustomView
import java.lang.Math.random
import kotlin.random.Random

class BlankFragment : BaseFragment<FragmentBlankBinding>(R.layout.fragment_blank) {

    override fun inflateBinding(layoutInflater: LayoutInflater, container: ViewGroup?): FragmentBlankBinding {
        return FragmentBlankBinding.inflate(layoutInflater, container, false)
    }

    /*
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        val linearLayout = LinearLayout(requireContext())
        linearLayout.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val ownCustomView = OwnCustomView(requireContext(), null)
        ownCustomView.apply {
            topLeftColor = Color.MAGENTA
            topRightColor = Color.GREEN
            bottomLeftColor = Color.YELLOW
            bottomRightColor = Color.BLUE
        }
        linearLayout.addView(ownCustomView)
        return linearLayout
    }
    */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 0 until 50) {
            val ownCustomView = OwnCustomView(requireContext())
//            val width = Random.nextInt(200) + 50
//            val height = Random.nextInt(100) + 100
            val width =  100
            val height = 100
            ownCustomView.layoutParams = ViewGroup.LayoutParams(width, height)
            ownCustomView.setPadding(5, 5, 5, 5)

            binding.customLayout.addView(ownCustomView)
        }
    }
}