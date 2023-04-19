package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ExpertExpertRecommendPageBinding
import cn.quibbler.lottery.databinding.ExpertMasterSelectionPageBinding
import cn.quibbler.lottery.databinding.ExpertSmartRecommendPageBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.ExpertRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.launcher.ARouter

class ExpertPageAdapter : PagerAdapter() {

    private val list = arrayOf(
        getAppString(R.string.bug_record_master), getAppString(R.string.bug_record_recommend), getAppString(R.string.lottery_grid_item_recommend)
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> {
                val binding = ExpertMasterSelectionPageBinding.inflate(LotteryApplication.layoutInflater, container, true).apply {
                    this.tabLayout.setupWithViewPager(this.viewPager)
                    this.viewPager.adapter = MasterSelectionPageAdapter()
                }
                binding.root
            }
            1 -> {
                val binding = ExpertSmartRecommendPageBinding.inflate(LotteryApplication.layoutInflater, container, true).apply {
                    this.tabLayout.setupWithViewPager(this.viewPager)
                    this.viewPager.adapter = ExpertSmartRecommendPageAdapter()
                    this.icon.visibility = View.VISIBLE
                    this.icon.setOnClickListener {
                        ARouter.getInstance()
                            .build(RouterCenter.about_smart_recommend_activity)
                            .withString(RouterCenter.argument_title, getAppString(R.string.intelligent_recommendation_instructions))
                            .navigation()
                    }
                }
                binding.root
            }
            2 -> {
                val binding = ExpertExpertRecommendPageBinding.inflate(LotteryApplication.layoutInflater, container, true).apply {
                    this.tabLayout.setupWithViewPager(this.viewPager)
                    this.viewPager.adapter = ExpertExpertRecommendPageAdapter()
                }
                binding.root
            }
            else -> {
                val recyclerView = RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    adapter = ExpertRecyclerViewAdapter()
                }
                container.addView(recyclerView)
                recyclerView
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getPageTitle(position: Int): CharSequence = list[position]

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

}