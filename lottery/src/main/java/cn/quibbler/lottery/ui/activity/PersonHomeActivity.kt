package cn.quibbler.lottery.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityPersonHomeBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.PersonHomePageAdapter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.self_person_home_page)
class PersonHomeActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPersonHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        try {
            window.statusBarColor = Color.parseColor("#fdecc9")
            findViewById<View>(R.id.action_bar).setBackgroundColor(Color.parseColor("#fdecc9"))
        } catch (ignore: Exception) {

        }

        showTitleRightIcon(AppCompatResources.getDrawable(this, R.drawable.my_settings_icon)) {
            ARouter.getInstance()
                .build(RouterCenter.self_personal_setting_page)
                .withString(RouterCenter.argument_title, getString(R.string.settings))
                .navigation()
        }

        binding.headIcon.setOnClickListener(this)
        binding.followLayout.setOnClickListener(this)
        binding.fansLayout.setOnClickListener(this)

        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.adapter = PersonHomePageAdapter()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.headIcon.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.decorate_center_page)
                    .withString(RouterCenter.argument_title, getAppString(R.string.personal_decorate_center))
                    .navigation()
            }
            binding.followLayout.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.activity_follow_and_fans)
                    .withString(RouterCenter.argument_title, getAppString(R.string.follow_or_fans))
                    .withInt(FollowAndFansActivity.SELECT_PAGE, FollowAndFansActivity.FOLLOW_PAGE)
                    .navigation()
            }
            binding.fansLayout.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.activity_follow_and_fans)
                    .withString(RouterCenter.argument_title, getAppString(R.string.follow_or_fans))
                    .withInt(FollowAndFansActivity.SELECT_PAGE, FollowAndFansActivity.FANS_PAGE)
                    .navigation()
            }
        }
    }

}