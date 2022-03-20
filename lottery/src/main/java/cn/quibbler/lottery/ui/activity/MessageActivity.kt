package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityMessageBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.MyMessagePageAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.message_activity)
class MessageActivity : BaseActivity() {

    private lateinit var binding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Android remove shadow line under ActionBar
        supportActionBar?.elevation = 0f

        initViews()
    }

    private fun initViews() {
        binding.viewPager.adapter = MyMessagePageAdapter()
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}