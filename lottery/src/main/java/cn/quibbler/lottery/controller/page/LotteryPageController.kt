package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.LotteryApplication.Companion.getContext
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageLotteryBinding
import cn.quibbler.lottery.ui.adapter.LotteryPageRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class LotteryPageController : Controller {

    private val binding = ViewPageLotteryBinding.inflate(LotteryApplication.getInflater())

    init {
        binding.recyclerView.layoutManager = LinearLayoutManager(getContext())
        binding.recyclerView.adapter = LotteryPageRecyclerViewAdapter()
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String? = getAppString(R.string.tab_label_lottery)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_lottery_selected)
    } else {
        getAppDrawable(R.drawable.tab_lottery_unselected)
    }

}