package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityPersonalDecorateCenterBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.DecorateCenterViewPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.decorate_center_page)
class PersonalDecorateCenterActivity : BaseActivity() {

    private lateinit var binding: ActivityPersonalDecorateCenterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalDecorateCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.viewPager.adapter = DecorateCenterViewPagerAdapter()
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}