package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityBuyRecordBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.BuyRecordViewPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_buy_record)
class BuyRecordActivity : BaseActivity() {

    private lateinit var binding: ActivityBuyRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initViews()
    }

    private fun initViews() {
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.adapter = BuyRecordViewPagerAdapter()
    }

}