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
import cn.quibbler.lottery.ui.adapter.*
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class HomePageController : Controller {

    private val binding = ViewPageHomeBinding.inflate(LotteryApplication.getInflater())

    init {
        val layoutManager = LinearLayoutManager(getContext())
        binding.mainMixedRecyclerView.layoutManager = layoutManager

        val firstAdapter = FirstBannerRecyclerAdapter()
        val secondAdapter = SecondScrollNewsRecyclerAdapter()
        val thirdAdapter = ThirdCardRecyclerAdapter()
        val fourthAdapter = FourthChooseNumRecyclerAdapter()
        val fifthAdapter = FifthFeaturedRecyclerAdapter()
        val sixAdapter = SixNewsRecyclerViewAdapter()

        val concatAdapter: ConcatAdapter = ConcatAdapter(firstAdapter, secondAdapter, thirdAdapter, fourthAdapter, fifthAdapter, sixAdapter)
        binding.mainMixedRecyclerView.adapter = concatAdapter
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String? = getAppString(R.string.tab_label_home)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_home_selected)
    } else {
        getAppDrawable(R.drawable.tab_home_unselected)
    }

}