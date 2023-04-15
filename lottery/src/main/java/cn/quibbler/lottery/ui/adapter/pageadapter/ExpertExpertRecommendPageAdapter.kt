package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.LotteryPageLocalItemBinding
import cn.quibbler.lottery.ui.adapter.LotteryPageRecyclerViewAdapter
import cn.quibbler.lottery.utils.getAppString

class ExpertExpertRecommendPageAdapter : PagerAdapter() {

    private val list = arrayOf(
        getAppString(R.string.follow),
        getAppString(R.string.bicolor_sphere),
        getAppString(R.string.lottery),
        getAppString(R.string.lucky_color_3D),
        getAppString(R.string.happy_8),
        getAppString(R.string.arrange_3),
        getAppString(R.string.arrange_5),
        getAppString(R.string.seven_star_colorful),
        getAppString(R.string.colorful_music)
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return RecyclerView(container.context).apply {
            layoutManager = LinearLayoutManager(LotteryApplication.application)
            adapter = LotteryPageRecyclerViewAdapter()
            container.addView(this)
            setPadding(
                container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                0,
                container.context.resources.getDimensionPixelSize(R.dimen.app_margin),
                0
            )
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

    override fun getPageTitle(position: Int): CharSequence = list[position]

}