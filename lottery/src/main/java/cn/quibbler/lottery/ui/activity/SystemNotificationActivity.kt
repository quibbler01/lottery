package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivitySystemNotificationBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.SystemNotificationRecyclerListAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_system_notification)
class SystemNotificationActivity : BaseActivity() {

    private lateinit var binding: ActivitySystemNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySystemNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.recyclerView.adapter = SystemNotificationRecyclerListAdapter()
    }

}