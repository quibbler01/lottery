package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityCouponBinding
import cn.quibbler.lottery.databinding.CouponNoDataDefaultLayoutBinding
import cn.quibbler.lottery.databinding.NoDataDefaultLayoutBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.self_activity_coupon)
class CouponActivity : BaseActivity() {

    private lateinit var binding: ActivityCouponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCouponBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.couponTabLayout.setupWithViewPager(binding.couponViewPager)
        binding.couponViewPager.adapter = ViewPagerAdapter()
    }

    private class ViewPagerAdapter : PagerAdapter() {

        private val list = arrayOf(
            "${getAppString(R.string.coupon_can_be_used)}(0)",
            getAppString(R.string.coupon_to_be_effective),
            getAppString(R.string.coupon_used)
        )

        override fun getCount(): Int = list.size

        override fun isViewFromObject(view: View, `object`: Any): Boolean = (view == `object`)

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val binding = CouponNoDataDefaultLayoutBinding.inflate(LotteryApplication.getInflater(), container, false)
            if (position != 0) {
                binding.showExpiredCoupon.visibility = View.GONE
            } else {
                binding.showExpiredCoupon.setOnClickListener {
                    ARouter.getInstance()
                        .build(RouterCenter.self_activity_expired_coupon)
                        .withString(RouterCenter.argument_title, getAppString(R.string.expired_coupon))
                        .navigation()
                }
            }
            container.addView(binding.root)
            return binding.root
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun getPageTitle(position: Int): CharSequence = list[position]
    }

}