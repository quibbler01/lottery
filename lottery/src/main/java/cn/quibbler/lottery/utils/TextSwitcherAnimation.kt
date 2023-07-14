package cn.quibbler.lottery.utils

import android.graphics.Color
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import android.widget.TextSwitcher
import android.widget.TextView
import cn.quibbler.lottery.LotteryApplication

class TextSwitcherAnimation(private var textSwitcher: TextSwitcher?, private var texts: List<String>) {
    var marker = 0
        private set
    private var inAnimationSet: AnimationSet? = null
    private var outAnimationSet: AnimationSet? = null
    private var delayTime = 2000
    private val task: Runnable = object : Runnable {
        override fun run() {
            nextView()
            LotteryApplication.handler.postDelayed(this, delayTime * 2L)
        }
    }

    fun start() {
        stop()
        LotteryApplication.handler.postDelayed(task, delayTime.toLong())
    }

    fun stop() {
        LotteryApplication.handler.removeCallbacks(task)
    }

    fun end() {
        stop()
        textSwitcher = null
    }

    fun setTexts(texts: List<String>): TextSwitcherAnimation {
        this.texts = texts
        return this
    }

    fun setDelayTime(delayTime: Int) {
        this.delayTime = delayTime
    }

    fun create() {
        marker = 0
        if (texts.isEmpty()) {
            Log.w("TextSwitcherAnimation", "texts is empty")
            return
        }
        if (textSwitcher == null) {
            Log.w("TextSwitcherAnimation", "textSwitcher is null")
            return
        }
        textSwitcher?.setText(texts[0])
        createAnimation()
        textSwitcher?.inAnimation = inAnimationSet
        textSwitcher?.outAnimation = outAnimationSet
        start()
    }

    private fun createAnimation() {

        var h = textSwitcher?.height ?: 0
        if (h <= 0) {
            textSwitcher?.measure(0, 0)
            h = textSwitcher?.measuredHeight ?: 0
        }
        inAnimationSet = AnimationSet(true)
        outAnimationSet = AnimationSet(true)
        var alphaAnimation: AlphaAnimation = AlphaAnimation(0f, 1f)
        var translateAnimation: TranslateAnimation = TranslateAnimation(
            Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0f,
            Animation.ABSOLUTE, h.toFloat(), Animation.ABSOLUTE, 0f
        )
        inAnimationSet?.addAnimation(alphaAnimation)
        inAnimationSet?.addAnimation(translateAnimation)
        inAnimationSet?.duration = DURATION.toLong()
        alphaAnimation = AlphaAnimation(1f, 0f)
        translateAnimation = TranslateAnimation(
            Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0f,
            Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, -h.toFloat()
        )
        outAnimationSet?.addAnimation(alphaAnimation)
        outAnimationSet?.addAnimation(translateAnimation)
        outAnimationSet?.duration = DURATION.toLong()
    }

    private fun nextView() {
        marker = ++marker % texts.size
        val textView = textSwitcher?.nextView as TextView
        textView.setTextColor(if (marker % 2 == 0) Color.RED else Color.BLACK)
        textSwitcher?.setText(texts[marker])
    }

    companion object {
        private const val DURATION = 1000
    }

}