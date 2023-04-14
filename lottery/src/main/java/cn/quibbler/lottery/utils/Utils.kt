package cn.quibbler.lottery.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import android.text.style.AbsoluteSizeSpan
import android.widget.EditText
import androidx.appcompat.content.res.AppCompatResources
import cn.quibbler.lottery.LotteryApplication.Companion.getApplicationContext
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets

/**
 * According to the resolution of the phone, the unit is converted from dp to px (pixel)
 *
 * @param context Context Interface to global information about an application environment.
 * @param dpValue Float value ine dp
 * @return Int value in px
 */
fun dip2px(context: Context, dpValue: Float): Int {
    val scale: Float = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

fun getAppDrawable(id: Int): Drawable? {
    return AppCompatResources.getDrawable(getApplicationContext(), id)
}

fun getAppString(id: Int): String = getApplicationContext().getString(id)

fun getColor(id: Int): Int = getApplicationContext().getColor(id)

fun getStringFromAsset(context: Context, fileName: String): String {
    var str = ""
    val assetManager: AssetManager = context.getAssets()
    try {
        val inputStream: InputStream = assetManager.open(fileName)
        val length: Int = inputStream.available()
        val buffer = ByteArray(length)
        inputStream.read(buffer)
        str = String(buffer, StandardCharsets.UTF_8)
    } catch (ignore: IOException) {
    }
    return str
}

fun setEditTextHintSize(editText: EditText, hintText: String?, size: Int) {
    val ss = SpannableString(hintText) //define the value of hint
    val ass = AbsoluteSizeSpan(size, true) //setting the font size to true indicates that the unit is dp
    ss.setSpan(ass, 0, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    editText.setHint(SpannedString(ss))
}
