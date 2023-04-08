package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.AdapterView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageSelfBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.MyCardAdapter
import cn.quibbler.lottery.ui.adapter.MyWealthCardAdapter
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.launcher.ARouter

class SelfPageController : Controller, View.OnClickListener {

    private val binding = ViewPageSelfBinding.inflate(LotteryApplication.getInflater())

    init {
        val wealthCardAdapter = MyWealthCardAdapter()
        binding.myWealthCard.adapter = wealthCardAdapter

        val cardAdapter = MyCardAdapter()
        binding.myAllCard.adapter = cardAdapter

        binding.myAllCard.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = cardAdapter.getItem(position)
                ARouter.getInstance()
                        .build(item.routePath)
                        .withString(RouterCenter.argument_title, item.label)
                        .navigation()
            }
        }

        binding.myMessage.setOnClickListener(this)
        binding.mySettings.setOnClickListener(this)
        binding.userLayout.setOnClickListener(this)
        binding.buyRecord.setOnClickListener(this)
        binding.simulateRecord.setOnClickListener(this)
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String = getAppString(R.string.tab_label_my)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_my_selected)
    } else {
        getAppDrawable(R.drawable.tab_my_unselected)
    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.myMessage.id -> {
                ARouter.getInstance()
                        .build(RouterCenter.message_activity)
                        .withString(RouterCenter.argument_title, getAppString(R.string.message))
                        .navigation()
            }
            binding.mySettings.id -> {
                ARouter.getInstance()
                        .build(RouterCenter.settings_activity)
                        .withString(RouterCenter.argument_title, getAppString(R.string.settings))
                        .navigation()
            }
            binding.userLayout.id -> {
                ARouter.getInstance()
                        .build(RouterCenter.self_person_home_page)
                        .withString(RouterCenter.argument_title, getAppString(R.string.person_home))
                        .navigation()
            }
            binding.buyRecord.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.self_buy_record)
                    .withString(RouterCenter.argument_title, getAppString(R.string.bug_record_title))
                    .navigation()
            }
            binding.simulateRecord.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.self_activity_simulate)
                    .withString(RouterCenter.argument_title, getAppString(R.string.simulate_record))
                    .navigation()
            }
        }
    }

}