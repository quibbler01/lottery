package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.feedback.HelpCenterController
import cn.quibbler.lottery.databinding.HelpCenterPageViewBinding
import cn.quibbler.lottery.databinding.NoDataDefaultLayoutBinding

class HelpFeedbackViewPagerAdapter : PagerAdapter() {

    companion object {
        val pageTitle = arrayOf(
            LotteryApplication.application.getString(R.string.help_center_title), LotteryApplication.application.getString(R.string.my_feedback_title)
        )
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> {
                val controller = HelpCenterController(HelpCenterPageViewBinding.inflate(LotteryApplication.getInflater(), container, false))
                container.addView(controller.getView())
                controller.getView()
            }
            else -> {
                val binding = NoDataDefaultLayoutBinding.inflate(LotteryApplication.getInflater(), container, false)
                container.addView(binding.root)
                binding.root
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = pageTitle.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getPageTitle(position: Int): CharSequence = pageTitle[position]

}