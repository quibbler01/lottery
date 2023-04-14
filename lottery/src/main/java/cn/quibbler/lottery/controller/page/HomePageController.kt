package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageHomeBinding
import cn.quibbler.lottery.repository.LoadCallback
import cn.quibbler.lottery.ui.adapter.pageadapter.HomePageAdapter
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class HomePageController : Controller, LoadCallback {

    private val binding = ViewPageHomeBinding.inflate(LotteryApplication.getInflater())

    private val DEFAULT_CHOOSE_POS = 1

    init {
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.adapter = HomePageAdapter()
        binding.viewPager.setCurrentItem(DEFAULT_CHOOSE_POS, false)
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String = getAppString(R.string.tab_label_home)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_home_selected)
    } else {
        getAppDrawable(R.drawable.tab_home_unselected)
    }

}