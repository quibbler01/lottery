package cn.quibbler.lottery.ui.activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatDrawableManager
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityHelpAndFeedBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.HelpFeedbackViewPagerAdapter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.tabs.TabLayout

@Route(path = RouterCenter.self_activity_help)
class HelpAndFeedActivity : BaseActivity() {

    private lateinit var binding: ActivityHelpAndFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpAndFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Android remove shadow line under ActionBar
        supportActionBar?.elevation = 0f

        initViews()
    }

    private fun initViews() {
        binding.viewPager.adapter = HelpFeedbackViewPagerAdapter()

        val tabLayout = TabLayout(this).apply {
            tabMode = TabLayout.MODE_FIXED
            setTabTextColors(Color.BLACK, Color.RED)
            tabRippleColor = null
        }

        setCustomCenterView(tabLayout)
        hideLeftTitle()
        showTitleRightIcon(AppCompatResources.getDrawable(this, R.drawable.feedback_icon)) {
            ARouter.getInstance()
                .build(RouterCenter.custom_service_home_page)
                .withString(RouterCenter.argument_title, getAppString(R.string.custom_services))
                .navigation()
        }

        tabLayout.setupWithViewPager(binding.viewPager)
    }

}