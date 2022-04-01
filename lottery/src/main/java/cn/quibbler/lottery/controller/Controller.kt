package cn.quibbler.lottery.controller

import android.graphics.drawable.Drawable
import android.view.View
import androidx.viewbinding.ViewBinding

interface Controller {

    fun getView(): View

    fun getDescription(): String? = null

    fun getDrawableIcon(selected: Boolean = false): Drawable? = null

    fun goTop() {}

    fun release() {}

}