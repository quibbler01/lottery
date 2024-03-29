package cn.quibbler.lottery

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.alibaba.android.arouter.launcher.ARouter
import com.scwang.smart.refresh.footer.BallPulseFooter
import com.scwang.smart.refresh.header.BezierRadarHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.tencent.mmkv.MMKV

class LotteryApplication : Application() {

    companion object {
        lateinit var application: Application
        lateinit var layoutInflater: LayoutInflater
        lateinit var handler: Handler

        fun getApplicationContext(): Context = application

        fun getInflater(): LayoutInflater = layoutInflater

        fun getMainHandler(): Handler = handler
    }

    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            BezierRadarHeader(context).setPrimaryColor(context.getColor(R.color.refresh_color))
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            BallPulseFooter(context).setAnimatingColor(context.getColor(R.color.refresh_color))
        }
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

        MMKV.initialize(this)
    }

}