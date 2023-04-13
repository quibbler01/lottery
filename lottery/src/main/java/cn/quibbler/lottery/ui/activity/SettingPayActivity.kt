package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivitySettingPayBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.settings_activity_pay)
class SettingPayActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySettingPayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initViews()
    }

    private fun initViews() {
        binding.passwordLayout.setOnClickListener(this)
        binding.backCardLayout.setOnClickListener(this)
        binding.realNameLayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.passwordLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_pay_set_password)
                    .withString(RouterCenter.argument_title, getAppString(R.string.set_pay_password))
                    .navigation()
            }
            binding.backCardLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_pay_bankcard)
                    .withString(RouterCenter.argument_title, getAppString(R.string.bank_card))
                    .navigation()
            }
            binding.realNameLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_pay_realname)
                    .withString(RouterCenter.argument_title, getAppString(R.string.real_name_information))
                    .navigation()
            }
        }
    }

}