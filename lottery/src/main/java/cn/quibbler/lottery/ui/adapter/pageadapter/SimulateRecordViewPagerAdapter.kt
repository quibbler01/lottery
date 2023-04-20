package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.SimulateAppendChoosePageBinding
import cn.quibbler.lottery.databinding.SimulateNormalChoosePageBinding
import cn.quibbler.lottery.utils.getAppString

class SimulateRecordViewPagerAdapter : PagerAdapter() {

    private val list = arrayOf(
        getAppString(R.string.simulate_record_normal_choose),
        getAppString(R.string.simulate_record_append_choose)
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> {
                val binding = SimulateNormalChoosePageBinding.inflate(LotteryApplication.getInflater(), container, false)
                container.addView(binding.root)
                binding.root
            }
            else -> {
                val binding = SimulateAppendChoosePageBinding.inflate(LotteryApplication.getInflater(), container, false)
                container.addView(binding.root)
                binding.root
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getPageTitle(position: Int): CharSequence = list[position]

}