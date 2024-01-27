package kz.dehaliboch.customViewsPlayground

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import androidx.fragment.app.transaction
import kz.dehaliboch.core.ui.base.BaseActivity
import kz.dehaliboch.customViewsPlayground.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit{
                replace(binding.fragmentContainerView.id, BlankFragment::class.java, null)
            }
        }
    }

}