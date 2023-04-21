package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.repository.LoadCallback
import cn.quibbler.lottery.ui.adapter.*
import cn.quibbler.lottery.utils.getAppString
import com.scwang.smart.refresh.layout.SmartRefreshLayout

class HomePageAdapter : PagerAdapter() {

    private val list = arrayOf(
        getAppString(R.string.recommend),
        getAppString(R.string.bicolor_sphere),
        getAppString(R.string.lottery),
        getAppString(R.string.lucky_color_3D),
        getAppString(R.string.happy_8),
        getAppString(R.string.arrange_3),
        getAppString(R.string.video),
        getAppString(R.string.arrange_5),
        getAppString(R.string.seven_star_colorful),
        getAppString(R.string.colorful_music),
        getAppString(R.string.number_selection_techniques),
        getAppString(R.string.winning_news),
    )

    private val bannerRecyclerAdapter = BannerRecyclerAdapter()
    private val scrollNewsRecyclerAdapter = ScrollNewsRecyclerAdapter()
    private val cardRecyclerAdapter = CardRecyclerAdapter()
    private val chooseNumRecyclerAdapter = ChooseNumRecyclerAdapter()
    private val featuredRecyclerAdapter = FeaturedRecyclerAdapter()
    private val popularLotteryTypeAdapter = PopularLotteryTypeAdapter()
    private val newsRecyclerViewAdapter = NewsRecyclerViewAdapter()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            1 -> {
                val recyclerView = RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    setPadding(
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0,
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0
                    )
                    adapter = ConcatAdapter(
                        bannerRecyclerAdapter,
                        scrollNewsRecyclerAdapter,
                        cardRecyclerAdapter,
                        chooseNumRecyclerAdapter,
                        featuredRecyclerAdapter,
                        popularLotteryTypeAdapter,
                        newsRecyclerViewAdapter
                    )
                }

                val smartRefreshLayout = SmartRefreshLayout(container.context).apply {
                    addView(recyclerView)
                    setOnRefreshListener {
                        it.finishRefresh(1000)
                    }
                    setOnLoadMoreListener {
                        newsRecyclerViewAdapter.requestNews(object : LoadCallback {
                            override fun onSuccess() {
                                finishLoadMore(true)
                            }

                            override fun onFailed() {
                                finishLoadMore(true)
                            }
                        })
                    }
                }

                container.addView(smartRefreshLayout)
                smartRefreshLayout
            }
            2 -> {
                val recyclerView = RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    setPadding(
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0,
                        container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                        0
                    )
                    adapter = ConcatAdapter(
                        cardRecyclerAdapter,
                        popularLotteryTypeAdapter,
                        newsRecyclerViewAdapter
                    )
                }

                val smartRefreshLayout = SmartRefreshLayout(container.context).apply {
                    addView(recyclerView)
                    setOnRefreshListener {
                        it.finishRefresh(1000)
                    }
                    setOnLoadMoreListener {
                        newsRecyclerViewAdapter.requestNews(object : LoadCallback {
                            override fun onSuccess() {
                                finishLoadMore(true)
                            }

                            override fun onFailed() {
                                finishLoadMore(true)
                            }
                        })
                    }
                }

                container.addView(smartRefreshLayout)
                smartRefreshLayout
            }
            else -> {
                val recyclerView = RecyclerView(container.context).apply {
                    layoutManager = LinearLayoutManager(LotteryApplication.application)
                    adapter = ExpertRecyclerViewAdapter()
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