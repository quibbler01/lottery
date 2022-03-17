package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageExpertBinding
import cn.quibbler.lottery.ui.adapter.ExpertRecyclerViewItem
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class ExpertPageController:Controller {

    private val binding = ViewPageExpertBinding.inflate(LotteryApplication.getInflater())

    init {
        binding.recyclerView.layoutManager = LinearLayoutManager(LotteryApplication.getContext())
        binding.recyclerView.adapter = ExpertRecyclerViewItem()
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String? = getAppString(R.string.tab_label_expert)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_expert_selected)
    } else {
        getAppDrawable(R.drawable.tab_expert_unselected)
    }

}