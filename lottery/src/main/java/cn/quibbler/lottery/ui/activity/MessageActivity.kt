package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityMessageBinding
import cn.quibbler.lottery.databinding.MessageNoticeHeadViewBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.MessageNoticeRecyclerViewAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.message_activity)
class MessageActivity : BaseActivity() {

    private lateinit var binding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Android remove shadow line under ActionBar
        supportActionBar?.elevation = 0f

        val headView = MessageNoticeHeadViewBinding.inflate(layoutInflater)
        headView.messageClearIcon.setOnClickListener {
            //TODO::clear message
        }

        setCustomCenterView(headView.root)
        hideLeftTitle()
        showTitleRightIcon(true, ResourcesCompat.getDrawable(resources, R.drawable.my_settings_icon, null)) {
            ARouter.getInstance()
                .build(RouterCenter.self_activity_message_settings)
                .withString(RouterCenter.argument_title, getString(R.string.message_settings_title))
                .navigation()
        }

        initViews()
    }

    private fun initViews() {
        binding.recyclerView.layoutManager = GridLayoutManager(this, 4)
        binding.recyclerView.adapter = MessageNoticeRecyclerViewAdapter()

        binding.systemNotificationView.setOnClickListener {
            ARouter.getInstance()
                .build(RouterCenter.self_activity_system_notification)
                .withString(RouterCenter.argument_title, getString(R.string.system_notification))
                .navigation()
        }
    }

}