package cn.quibbler.lottery.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import cn.quibbler.lottery.LotteryApplication.Companion.getContext
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets

fun getAppDrawable(id: Int): Drawable? {
    return AppCompatResources.getDrawable(getContext(), id)
}

fun getAppString(id: Int): String = getContext().getString(id)


fun getStringFromAsset(context: Context, fileName: String): String {
    var str = ""
    val assetManager: AssetManager = context.getAssets()
    try {
        val inputStream: InputStream = assetManager.open(fileName)
        val length: Int = inputStream.available()
        val buffer = ByteArray(length)
        inputStream.read(buffer)
        str = String(buffer, StandardCharsets.UTF_8)
    } catch (e: IOException) {
    }
    return str
}