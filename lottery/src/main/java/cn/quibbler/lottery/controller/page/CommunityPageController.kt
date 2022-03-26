package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.quibbler.lottery.LotteryApplication.Companion.getContext
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageCommunityBinding
import cn.quibbler.lottery.ui.adapter.DefaultEmptyRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class CommunityPageController : Controller {

    private val binding = ViewPageCommunityBinding.inflate(getInflater())
    private val layoutManager = LinearLayoutManager(getContext())

    init {
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = DefaultEmptyRecyclerViewAdapter()
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String? = getAppString(R.string.tab_label_community)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_community_selected)
    } else {
        getAppDrawable(R.drawable.tab_community_unselected)
    }

    override fun goTop() {
        if (layoutManager.findFirstVisibleItemPosition() == 0) {
            binding.smartRefreshLayout.autoRefresh()
        } else {
            binding.recyclerView.smoothScrollToPosition(0)
        }
    }

}