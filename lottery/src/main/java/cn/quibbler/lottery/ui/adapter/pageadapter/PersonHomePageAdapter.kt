package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.NoDataDefaultLayoutBinding
import cn.quibbler.lottery.utils.getAppString

class PersonHomePageAdapter : PagerAdapter() {

    private val list = arrayOf(getAppString(R.string.dynamic), getAppString(R.string.interaction), getAppString(R.string.select_number))

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = NoDataDefaultLayoutBinding.inflate(LotteryApplication.layoutInflater, container, true)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

    override fun getPageTitle(position: Int): CharSequence = list[position]

}