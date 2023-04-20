package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.decoratecenter.AvatarController
import cn.quibbler.lottery.controller.decoratecenter.DynamicBackgroundCardController
import cn.quibbler.lottery.databinding.AvatarPendantViewPageBinding
import cn.quibbler.lottery.databinding.DynamicBackgroundCardViewPageBinding
import cn.quibbler.lottery.utils.getAppString

class DecorateCenterViewPagerAdapter : PagerAdapter() {

    private val list = listOf(getAppString(R.string.avatar_pendant), getAppString(R.string.dynamic_background_card))

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> {
                val binding = AvatarPendantViewPageBinding.inflate(LotteryApplication.layoutInflater, container, false)
                val controller = AvatarController(binding)
                container.addView(controller.getView())
                controller.getView()
            }
            else -> {
                val binding = DynamicBackgroundCardViewPageBinding.inflate(LotteryApplication.layoutInflater, container, false)
                val controller = DynamicBackgroundCardController(binding)
                container.addView(controller.getView())
                controller.getView()
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

    override fun getPageTitle(position: Int): CharSequence = list[position]

}