package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityViolationNotificationBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.ViolationViewPageAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_violation_notification)
class ViolationNotificationActivity : BaseActivity() {

    private lateinit var binding: ActivityViolationNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViolationNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.violationViewPager.adapter = ViolationViewPageAdapter()
        binding.violationTabLayout.setupWithViewPager(binding.violationViewPager)
    }

}