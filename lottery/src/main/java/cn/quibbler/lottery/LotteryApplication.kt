package cn.quibbler.lottery

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.alibaba.android.arouter.launcher.ARouter

class LotteryApplication : Application() {

    companion object {
        lateinit var application: Application
        lateinit var layoutInflater: LayoutInflater
        lateinit var handler: Handler

        fun getContext(): Context = application
        fun getInflater(): LayoutInflater = layoutInflater
        fun getMainHandler(): Handler = handler
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        application = this
    }

    override fun onCreate() {
        super.onCreate()
        handler = Handler(Looper.getMainLooper())
        application.setTheme(R.style.Theme_Lottery)
        layoutInflater = LayoutInflater.from(this)

        initSDKs()
    }

    private fun initSDKs() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

}