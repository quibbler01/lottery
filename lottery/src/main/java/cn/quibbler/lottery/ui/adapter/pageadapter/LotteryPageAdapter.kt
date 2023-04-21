package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.LotteryPageLocalItemBinding
import cn.quibbler.lottery.ui.adapter.LocalLotteryRecyclerAdapter
import cn.quibbler.lottery.ui.adapter.LotteryPageRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppString

class LotteryPageAdapter : PagerAdapter() {

    private val list = arrayOf(getAppString(R.string.national_lottery), getAppString(R.string.local_lottery))

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> {
                RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    adapter = LotteryPageRecyclerViewAdapter()
                    setPadding(
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0,
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0
                    )
                    container.addView(this)
                }
            }
            else -> {
                val binding = LotteryPageLocalItemBinding.inflate(LotteryApplication.layoutInflater, container, true)
                binding.recyclerView.adapter = LocalLotteryRecyclerAdapter()
                binding.root
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

    override fun getPageTitle(position: Int): CharSequence = list[position]

}