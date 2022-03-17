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

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    it.setIcon(controllers[it.position].getDrawableIcon(true))
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.let {
                    it.setIcon(controllers[it.position].getDrawableIcon(false))
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        binding.tabLayout.setupWithViewPager(binding.viewPager)
        for (index in 0 until binding.tabLayout.tabCount) {
            binding.tabLayout.getTabAt(index)?.let {
                it.icon = controllers[index].getDrawableIcon(it.isSelected)
            }
        }
    }

    override fun getView(): View = binding.root

}