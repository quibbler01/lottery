package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.LotteryApplication.Companion.getContext
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageHomeBinding
import cn.quibbler.lottery.repository.LoadCallback
import cn.quibbler.lottery.ui.adapter.*
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class HomePageController : Controller, LoadCallback {

    private val binding = ViewPageHomeBinding.inflate(LotteryApplication.getInflater())

    private val firstAdapter = FirstBannerRecyclerAdapter()
    private val secondAdapter = SecondScrollNewsRecyclerAdapter()
    private val thirdAdapter = ThirdCardRecyclerAdapter()
    private val fourthAdapter = FourthChooseNumRecyclerAdapter()
    private val fifthAdapter = FifthFeaturedRecyclerAdapter()
    private val sixAdapter = SixNewsRecyclerViewAdapter()
    private val concatAdapter: ConcatAdapter = ConcatAdapter(firstAdapter, secondAdapter, thirdAdapter, fourthAdapter, fifthAdapter, sixAdapter)

    init {
        val layoutManager = LinearLayoutManager(getContext())
        layoutManager.isAutoMeasureEnabled = true
        binding.mainMixedRecyclerView.layoutManager = layoutManager
        binding.mainMixedRecyclerView.adapter = concatAdapter

        binding.smartRefreshLayout.setOnRefreshListener {
            it.finishRefresh(1000)
        }
        binding.smartRefreshLayout.setOnLoadMoreListener {
            sixAdapter.requestNews(this)
        }
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String? = getAppString(R.string.tab_label_home)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_home_selected)
    } else {
        getAppDrawable(R.drawable.tab_home_unselected)
    }

    override fun onSuccess() {
        binding.smartRefreshLayout.finishLoadMore(true)
    }

    override fun onFailed() {
        binding.smartRefreshLayout.finishLoadMore(false)
    }

}