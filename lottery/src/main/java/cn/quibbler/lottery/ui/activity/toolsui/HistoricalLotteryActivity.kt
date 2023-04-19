package cn.quibbler.lottery.ui.activity.toolsui

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityHistoricalLotteryBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import cn.quibbler.lottery.ui.adapter.pageadapter.HistoricalLotteryPageAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.historical_lottery_activity)
class HistoricalLotteryActivity : BaseActivity() {

    private lateinit var binding: ActivityHistoricalLotteryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricalLotteryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.viewPager.offscreenPageLimit = 2
        binding.viewPager.adapter = HistoricalLotteryPageAdapter()
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}