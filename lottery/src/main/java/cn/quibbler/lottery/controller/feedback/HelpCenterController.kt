package cn.quibbler.lottery.controller.feedback

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.HelpCenterPageViewBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.HelpCenterRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.launcher.ARouter

class HelpCenterController(val binding: HelpCenterPageViewBinding) : Controller {

    override fun getView(): View = binding.root

    init {

        initViews()

    }

    private fun initViews() {
        binding.feedbackButton.setOnClickListener {
            ARouter.getInstance()
                .build(RouterCenter.feed_back_page)
                .withString(RouterCenter.argument_title, getAppString(R.string.feed_back))
                .navigation()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(LotteryApplication.application)
        binding.recyclerView.adapter = HelpCenterRecyclerViewAdapter()
    }

}