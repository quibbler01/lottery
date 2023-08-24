package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.CommunityLuckyTicketPageItemBinding
import cn.quibbler.lottery.databinding.NoDataDefaultLayoutBinding
import cn.quibbler.lottery.ui.adapter.communityadapter.*
import cn.quibbler.lottery.ui.adapter.communityadapter.HotTopicAdapter
import cn.quibbler.lottery.utils.getAppString
import com.scwang.smart.refresh.layout.SmartRefreshLayout

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
                binding.text.text = getAppString(R.string.you_don_t_follow_any_user)
                binding.root
            }

            1 -> {
                val recyclerView = RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    adapter = ConcatAdapter().apply {
                        /*addAdapter(CommunityFunctionAdapter())
                        addAdapter(HotTopicAdapter())
                        addAdapter(VotingTopicsAdapter())
                        addAdapter(PersonalDecorateAdapter())
                        addAdapter(CommunityPostAdapter())*/
                    }
                    setPadding(
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0,
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0
                    )
                }
                val smartRefreshLayout = SmartRefreshLayout(container.context).apply {
                    addView(recyclerView)
                    setOnRefreshListener {
                        it.finishRefresh(1000)
                    }
                    setOnLoadMoreListener {

                    }
                }
                container.addView(smartRefreshLayout)
                smartRefreshLayout
            }

            else -> {
                val binding = CommunityLuckyTicketPageItemBinding.inflate(LotteryApplication.layoutInflater, container, true)
                binding.tabLayout.setupWithViewPager(binding.viewPager)
                binding.viewPager.adapter = CommunityLuckyTicketPageAdapter()
                binding.root
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