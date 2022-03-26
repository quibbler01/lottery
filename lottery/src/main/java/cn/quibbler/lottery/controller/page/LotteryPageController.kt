package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.LotteryApplication.Companion.getContext
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageLotteryBinding
import cn.quibbler.lottery.repository.LoadCallback
import cn.quibbler.lottery.ui.adapter.LotteryPageRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString
import com.scwang.smart.refresh.header.ClassicsHeader

class LotteryPageController : Controller, LoadCallback {

    private val binding = ViewPageLotteryBinding.inflate(LotteryApplication.getInflater())
    private val adapter = LotteryPageRecyclerViewAdapter()
    private val layoutManager = LinearLayoutManager(getContext())

    init {
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        binding.smartRefreshLayout.setRefreshHeader(ClassicsHeader(getContext()))
        binding.smartRefreshLayout.setOnRefreshListener {
            it.finishRefresh(1000)
        }
        binding.smartRefreshLayout.setOnLoadMoreListener {
            adapter.requestNextPageData(this)
        }
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String? = getAppString(R.string.tab_label_lottery)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_lottery_selected)
    } else {
        getAppDrawable(R.drawable.tab_lottery_unselected)
    }

    override fun onSuccess() {
        binding.smartRefreshLayout.finishLoadMore(true)
    }

    override fun onFailed() {
        binding.smartRefreshLayout.finishLoadMore(false)
    }

    override fun goTop() {
        if (layoutManager.findFirstVisibleItemPosition() == 0) {
            binding.smartRefreshLayout.autoRefresh()
        } else {
            binding.recyclerView.smoothScrollToPosition(0)
        }
    }

}