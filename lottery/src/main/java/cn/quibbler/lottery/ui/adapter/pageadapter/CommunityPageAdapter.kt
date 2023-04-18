package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.CommunityLuckyTicketPageItemBinding
import cn.quibbler.lottery.databinding.NoDataDefaultLayoutBinding
import cn.quibbler.lottery.ui.adapter.DefaultEmptyRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppString

class CommunityPageAdapter : PagerAdapter() {

    private val list =
        arrayOf(
            getAppString(R.string.follow),
            getAppString(R.string.recommend),
            getAppString(R.string.lucky_ticket)
        )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> {
                val binding = NoDataDefaultLayoutBinding.inflate(LotteryApplication.layoutInflater, container, true)
                binding.text.text = getAppString(R.string.sorry_no_data)
                binding.root
            }
            2 -> {
                val binding = CommunityLuckyTicketPageItemBinding.inflate(LotteryApplication.layoutInflater, container, true)
                binding.tabLayout.setupWithViewPager(binding.viewPager)
                binding.viewPager.adapter = CommunityLuckyTicketPageAdapter()
                binding.root
            }
            else -> {
                val recyclerView = RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    adapter = DefaultEmptyRecyclerViewAdapter()
                    setPadding(
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0,
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0
                    )
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