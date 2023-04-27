package cn.quibbler.lottery.ui.activity.toolsui

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivitySimulatedNumberSelectionBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import cn.quibbler.lottery.ui.adapter.pageadapter.SimulatePageAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.simulated_number_selection_activity)
class SimulatedNumberSelectionActivity : BaseActivity() {

    private lateinit var binding: ActivitySimulatedNumberSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimulatedNumberSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.viewPager.setCurrentItem(1, false)
        binding.viewPager.adapter = SimulatePageAdapter()
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}