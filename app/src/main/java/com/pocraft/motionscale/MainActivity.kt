package com.pocraft.motionscale

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.pocraft.motionscale.databinding.ActivityMainBinding
import com.pocraft.motionscale.empty.EmptyFragment
import com.pocraft.motionscale.setting.SettingFragment
import kotlin.math.abs

class MainActivity : AppCompatActivity(), MotionLayout.TransitionListener {
    private var settingFragment : Fragment? = null

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val sampleToolsResIds = listOf(
        R.drawable.ic_baseline_access_time_24,
        R.drawable.ic_baseline_add_circle_outline_24,
        R.drawable.ic_baseline_local_cafe_24,
        R.drawable.ic_baseline_share_24,
        R.drawable.ic_baseline_thumb_up_24,
        R.drawable.ic_baseline_play_arrow_24,
        R.drawable.ic_baseline_wb_incandescent_24,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val toolsDrawable = sampleToolsResIds.map {
            ResourcesCompat.getDrawable(resources, it, null)
        }
        with(binding) {
            mainMotionLayout.setTransitionListener(this@MainActivity)
            toolbarCarousel.carousel.setAdapter(object : Carousel.Adapter {
                override fun count(): Int = sampleToolsResIds.size

                override fun populate(view: View?, index: Int) {
                    if (view is ImageView) {
                        view.setImageDrawable(toolsDrawable[index])
                    }
                }

                override fun onNewItem(index: Int) {
                }

            })

            weatherModule.root.let { motionLayout ->
                motionLayout.setOnClickListener {
                    when (motionLayout.currentState) {
                        R.id.start -> motionLayout.transitionToEnd()
                        else -> motionLayout.transitionToStart()
                    }
                }
            }
        }
        if (savedInstanceState == null) {
            settingFragment = EmptyFragment.newInstance().also {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.setting_fragment_container, it)
                    .commitNow()
            }
        }
        setContentView(binding.root)
    }

    override fun onTransitionStarted(p0: MotionLayout?, startId: Int, endId: Int) {
        when {
            startId == R.id.setting_expanded -> {
                if (settingFragment is SettingFragment) transitFragmentToEmpty()
            }
        }
    }

    override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
        when {
            endId == R.id.setting_expanded -> {
                val atEnd = abs(progress - 1f) < 0.1f
                if (atEnd && settingFragment is EmptyFragment) transitFragmentToSetting()
            }
        }
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
    }

    private fun transitFragmentToSetting() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .setCustomAnimations(R.animator.show, 0)
        settingFragment = SettingFragment.newInstance().also {
            transaction
                .replace(R.id.setting_fragment_container, it)
                .commitNow()
        }
    }

    private fun transitFragmentToEmpty() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .setCustomAnimations(0, R.animator.hide)
        settingFragment = EmptyFragment.newInstance().also {
            transaction
                .replace(R.id.setting_fragment_container, it)
                .commitNow()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}