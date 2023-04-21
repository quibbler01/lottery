package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityIncentiveMoneyBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.self_activity_incentive_money)
class IncentiveMoneyActivity : BaseActivity() {

    private lateinit var binding: ActivityIncentiveMoneyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncentiveMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        showRightTitleText(getString(R.string.reward_details)) {
            ARouter.getInstance()
                .build(RouterCenter.self_activity_incentive_money_detail)
                .withString(RouterCenter.argument_title, getString(R.string.reward_details))
                .navigation()
        }

        initView()
    }

    private fun initView() {
        binding.withdrawalLayout.setOnClickListener {
            ARouter.getInstance()
                .build(RouterCenter.settings_activity_pay_set_password)
                .withString(RouterCenter.argument_title, getString(R.string.set_pay_password))
                .navigation()
        }
    }

}