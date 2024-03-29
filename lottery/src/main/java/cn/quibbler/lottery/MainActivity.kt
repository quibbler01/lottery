package cn.quibbler.lottery

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import cn.quibbler.lottery.controller.MainController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 28) {
            val layoutParam: WindowManager.LayoutParams = window.attributes
            layoutParam.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            window.attributes = layoutParam
        }

        setContentView(MainController.getView())
    }

    override fun onDestroy() {
        super.onDestroy()
        MainController.release()
    }

}