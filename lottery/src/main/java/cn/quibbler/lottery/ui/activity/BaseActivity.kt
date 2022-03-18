package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cn.quibbler.lottery.R
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseActivity : AppCompatActivity() {

    @Autowired(name = RouterCenter.argument_title)
    @JvmField
    var titleLabel: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Normal)
        window.setBackgroundDrawable(null)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ARouter.getInstance().inject(this)
        title = titleLabel ?: getAppString(R.string.app_name)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            else -> {}
        }
        return true
    }

}