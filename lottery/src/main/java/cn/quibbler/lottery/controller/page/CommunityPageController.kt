package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageCommunityBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.CommunityPageAdapter
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.launcher.ARouter

class CommunityPageController : Controller {

    private val binding = ViewPageCommunityBinding.inflate(getInflater())

    private val defaultChoosePos = 1

    init {
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.adapter = CommunityPageAdapter()
        binding.viewPager.setCurrentItem(defaultChoosePos, false)
        binding.selfIcon.setOnClickListener {
            ARouter.getInstance()
                .build(RouterCenter.self_person_home_page)
                .withString(RouterCenter.argument_title, getAppString(R.string.person_home))
                .navigation()
        }
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String = getAppString(R.string.tab_label_community)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_community_selected)
    } else {
        getAppDrawable(R.drawable.tab_community_unselected)
    }

}