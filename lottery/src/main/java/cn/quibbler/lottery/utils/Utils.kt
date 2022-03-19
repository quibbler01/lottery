package cn.quibbler.lottery.utils

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import cn.quibbler.lottery.LotteryApplication.Companion.getContext

fun getAppDrawable(id: Int): Drawable? {
    return AppCompatResources.getDrawable(getContext(), id)
}

fun getAppString(id: Int): String = getContext().getString(id)
