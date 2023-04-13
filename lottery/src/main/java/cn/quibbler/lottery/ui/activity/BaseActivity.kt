package cn.quibbler.lottery.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.CustomTitleBarViewBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseActivity : AppCompatActivity() {

    @Autowired(name = RouterCenter.argument_title)
    @JvmField
    var titleLabel: String? = null

    private lateinit var titleBinding: CustomTitleBarViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //auto inject var titleLabel
        ARouter.getInstance().inject(this)

        setTheme(R.style.Theme_Normal)
        window.setBackgroundDrawable(null)
        initActionBar()
    }

    private fun initActionBar() {
        titleBinding = CustomTitleBarViewBinding.inflate(layoutInflater)
        titleBinding.title.text = titleLabel ?: getAppString(R.string.app_name)
        titleBinding.backArrow.setOnClickListener {
            finish()
        }

        try {
            val actionBarContainer: ViewGroup? = findViewById(R.id.action_bar_container)
            actionBarContainer?.let {
                it.layoutParams.height = resources.getDimensionPixelSize(R.dimen.action_bar_height)
            }
        } catch (ignore: Exception) {
        }

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.customView = titleBinding.root
        supportActionBar?.setDisplayShowCustomEnabled(true)
    }

    protected fun hideLeftTitle() {
        titleBinding.title.visibility = View.INVISIBLE
    }

    protected fun setCustomCenterView(@LayoutRes layoutResId: Int) {
        val view = LayoutInflater.from(this).inflate(layoutResId, null, false)
        titleBinding.actionContainer.visibility = View.VISIBLE
        titleBinding.actionContainer.addView(view)
    }

    protected fun setCustomCenterView(view: View) {
        titleBinding.actionContainer.visibility = View.VISIBLE
        titleBinding.actionContainer.addView(view)
    }

    protected fun showTitleRightIcon(drawable: Drawable? = null, clickListener: View.OnClickListener? = null) {
        titleBinding.rightIcon.visibility = View.VISIBLE
        titleBinding.rightIcon.setImageDrawable(drawable)
        titleBinding.rightIcon.setOnClickListener(clickListener)

        titleBinding.rightTitleBtn.visibility = View.GONE
    }

    protected fun showRightTitleText(text: String? = null, clickListener: View.OnClickListener? = null) {
        titleBinding.rightTitleBtn.visibility = View.VISIBLE
        titleBinding.rightTitleBtn.text = text
        titleBinding.rightTitleBtn.setOnClickListener(clickListener)

        titleBinding.rightIcon.visibility = View.GONE
    }

    protected fun setRightTitleText(text: String? = null){
        titleBinding.rightTitleBtn.text = text
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