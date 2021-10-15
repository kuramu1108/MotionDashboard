package com.pocraft.motionscale

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import com.pocraft.motionscale.databinding.ToolbarCarouselBinding

class Sample2Activity : AppCompatActivity() {
    private var _binding: ToolbarCarouselBinding? = null
    private val binding: ToolbarCarouselBinding
        get() = _binding!!

    private val sampleToolsResIds = listOf(
        R.drawable.ic_baseline_access_time_24,
        R.drawable.ic_baseline_add_circle_outline_24,
        R.drawable.ic_baseline_local_cafe_24,
        R.drawable.ic_baseline_share_24,
        R.drawable.ic_baseline_thumb_up_24,
        R.drawable.ic_baseline_play_arrow_24,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ToolbarCarouselBinding.inflate(layoutInflater)

        with(binding) {
            carousel.setAdapter(object : Carousel.Adapter {
                override fun count(): Int = sampleToolsResIds.size

                override fun populate(view: View?, index: Int) {
                    if (view is ImageView) {
                        view.setImageResource(sampleToolsResIds[index])
                    }
                }

                override fun onNewItem(index: Int) {
                }

            })
        }
        setContentView(binding.root)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, Sample2Activity::class.java)
    }
}