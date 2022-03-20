package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivitySettingsBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.RouterCenter.settings_activity_about
import cn.quibbler.lottery.model.RouterCenter.settings_activity_account
import cn.quibbler.lottery.model.RouterCenter.settings_activity_pay
import cn.quibbler.lottery.model.RouterCenter.settings_activity_upgrade
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.settings_activity)
class SettingsActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Android remove shadow line under ActionBar
        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.settingAccount.setOnClickListener(this)
        binding.settingPay.setOnClickListener(this)
        binding.settingUpgrade.setOnClickListener(this)
        binding.settingAbout.setOnClickListener(this)
        binding.logOut.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.settingAccount.id -> {
                ARouter.getInstance().build(settings_activity_account)
                        .withString(RouterCenter.argument_title, getAppString(R.string.settings_safe))
                        .navigation()
            }
            binding.settingPay.id -> {
                ARouter.getInstance().build(settings_activity_pay)
                        .withString(RouterCenter.argument_title, getAppString(R.string.settings_pay))
                        .navigation()
            }
            binding.settingUpgrade.id -> {
                ARouter.getInstance().build(settings_activity_upgrade)
                        .navigation()
            }
            binding.settingAbout.id -> {
                ARouter.getInstance().build(settings_activity_about)
                        .withString(RouterCenter.argument_title, getAppString(R.string.settings_about))
                        .navigation()
            }
            binding.logOut.id -> {
                //
            }
        }
    }

}