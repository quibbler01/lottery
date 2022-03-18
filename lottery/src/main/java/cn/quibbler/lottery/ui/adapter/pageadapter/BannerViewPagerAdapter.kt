package cn.quibbler.lottery.ui.adapter.pageadapter

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.BannerViewPagerItemBinding
import cn.quibbler.lottery.utils.getAppDrawable

class BannerViewPagerAdapter : PagerAdapter() {

    private val bannerList = ArrayList<Drawable?>()

    init {
        bannerList.add(getAppDrawable(R.drawable.banner_image_one))
        bannerList.add(getAppDrawable(R.drawable.banner_image_two))
        bannerList.add(getAppDrawable(R.drawable.banner_image_three))
        bannerList.add(getAppDrawable(R.drawable.banner_image_four))
        bannerList.add(getAppDrawable(R.drawable.banner_image_five))
    }

    override fun getCount(): Int = bannerList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = (view == `object`)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = BannerViewPagerItemBinding.inflate(getInflater(), container, false)
        binding.imageView.setImageDrawable(bannerList[position])
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}