package cn.quibbler.lottery.controller

import android.view.View
import cn.quibbler.lottery.LotteryApplication.Companion.layoutInflater
import cn.quibbler.lottery.controller.page.*
import cn.quibbler.lottery.databinding.ActivityMainBinding
import cn.quibbler.lottery.ui.adapter.pageadapter.MainViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainController() : Controller {

    private var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    private val controllers = ArrayList<Controller>()

    init {
        initControllers()
        initView()
    }

    private fun initControllers() {
        controllers.add(HomePageController())
        controllers.add(LotteryPageController())
        controllers.add(ExpertPageController())
        controllers.add(CommunityPageController())
        controllers.add(SelfPageController())
    }

    private fun initView() {
        binding.viewPager.adapter = MainViewPagerAdapter(controllers)

        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.tabRippleColor = null
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            var lastClickTime: Long = 0L
            var lastClickPosition: Int = 0

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    it.icon = controllers[it.position].getDrawableIcon(true)
                    lastClickTime = System.currentTimeMillis()
                    lastClickPosition = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.let {
                    it.icon = controllers[it.position].getDrawableIcon(false)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.let {
                    if (it.position == lastClickPosition && (System.currentTimeMillis() - lastClickTime < 500)) {
                        controllers[it.position].goTop()
                    }
                    lastClickTime = System.currentTimeMillis()
                    lastClickPosition = it.position
                }
            }
        })

        for (index in 0 until binding.tabLayout.tabCount) {
            binding.tabLayout.getTabAt(index)?.let {
                it.icon = controllers[index].getDrawableIcon(it.isSelected)
            }
        }
    }

    override fun getView(): View = binding.root

    override fun release() {
        for (c in controllers) {
            c.release()
        }
    }

}