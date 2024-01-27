package kz.dehaliboch.customViewsPlayground

import android.view.LayoutInflater
import kz.dehaliboch.core.ui.base.BaseActivity
import kz.dehaliboch.customViewsPlayground.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


}