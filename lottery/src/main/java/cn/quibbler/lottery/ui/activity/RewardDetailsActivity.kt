package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityRewardDetailsBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_incentive_money_detail)
class RewardDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityRewardDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 1f
    }

}