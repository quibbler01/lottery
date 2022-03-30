package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.NoDataDefaultLayoutBinding
import cn.quibbler.lottery.databinding.NotifyPageLayoutBinding
import cn.quibbler.lottery.utils.getAppString
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.FalsifyHeader

class MyMessagePageAdapter : PagerAdapter() {

    private val list = arrayListOf<String>(getAppString(R.string.remind), getAppString(R.string.notify))

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return if (position == 0) {
            val binding = NoDataDefaultLayoutBinding.inflate(getInflater(), container, false)
            container.addView(binding.root)
            binding.root
        } else {
            val binding = NotifyPageLayoutBinding.inflate(getInflater(), container, false)
            binding.smartRefreshLayout.setRefreshHeader(FalsifyHeader(container.context))
            binding.smartRefreshLayout.setRefreshFooter(ClassicsFooter(container.context))
            container.addView(binding.root)
            binding.root
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getPageTitle(position: Int): CharSequence = list[position]

}