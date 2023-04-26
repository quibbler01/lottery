package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.SameDatePageAdapterItemBinding
import cn.quibbler.lottery.databinding.SameFraquencyPageAdapterItemBinding
import cn.quibbler.lottery.databinding.SameWeekendPageAdapterItemBinding
import cn.quibbler.lottery.ui.adapter.HistoryOpenLotteryRecyclerAdapter
import cn.quibbler.lottery.ui.adapter.SameWeekendPageRecyclerAdapter
import cn.quibbler.lottery.utils.getAppString

class HistoricalLotteryPageAdapter : PagerAdapter() {

    private val list = arrayOf(
        getAppString(R.string.lottery_grid_item_history),
        getAppString(R.string.same_week),
        getAppString(R.string.same_frequency),
        getAppString(R.string.same_date)
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> {
                RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    adapter = HistoryOpenLotteryRecyclerAdapter()
                    container.addView(this)
                }
            }
            1 -> {
                val binding = SameWeekendPageAdapterItemBinding.inflate(LotteryApplication.getInflater(), container, true)
                binding.recyclerView.adapter = SameWeekendPageRecyclerAdapter()
                binding.root
            }
            2 -> {
                val binding = SameFraquencyPageAdapterItemBinding.inflate(LotteryApplication.getInflater(), container, true)
                binding.recyclerView.adapter = HistoryOpenLotteryRecyclerAdapter()
                binding.root
            }
            3 -> {
                val binding = SameDatePageAdapterItemBinding.inflate(LotteryApplication.getInflater(), container, true)
                binding.recyclerView.adapter = HistoryOpenLotteryRecyclerAdapter()
                binding.root
            }
            else -> {
                throw IllegalStateException("can't reach here,tab only has ${list.size}")
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