package cn.quibbler.lottery.initializer

import android.content.Context
import androidx.startup.Initializer

class InitModule : Initializer<Unit> {

    override fun create(context: Context) {

    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()

}