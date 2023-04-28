package cn.quibbler.lottery.controller.simulate

import android.animation.Animator
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.view.animation.LinearInterpolator
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.SimulateInheritanceLayoutBinding

class InheritanceSimulateController(val binding: SimulateInheritanceLayoutBinding) : Controller {

    init {
        initView()
    }

    private fun initView() {
        binding.startSimulate.setOnClickListener {
            val rotationAnimator = ObjectAnimator.ofFloat(binding.frameSimulate, "rotation", 0f, 360f)
            rotationAnimator.interpolator = LinearInterpolator()
            rotationAnimator.duration = 2000
            rotationAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    binding.frameSimulate.visibility = View.VISIBLE
                }

                override fun onAnimationEnd(animation: Animator) {
                    binding.frameSimulate.visibility = View.INVISIBLE
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })
            rotationAnimator.start()
        }
    }

    override fun getView(): View = binding.root

}