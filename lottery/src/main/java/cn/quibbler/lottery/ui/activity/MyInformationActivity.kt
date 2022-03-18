package cn.quibbler.lottery.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityMyInformationBinding
import cn.quibbler.lottery.databinding.NoDataDefaultLayoutBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_information)
class MyInformationActivity : BaseActivity() {

    private lateinit var binding: ActivityMyInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Android remove shadow line under ActionBar
        supportActionBar?.elevation = 0f

        binding = ActivityMyInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.viewPager.adapter = ViewPagerAdapter()
        binding.talLayout.setupWithViewPager(binding.viewPager)
    }

    private class ViewPagerAdapter : PagerAdapter() {

        private val list = arrayOf(getAppString(R.string.my_information_great),
                getAppString(R.string.my_information_collection),
                getAppString(R.string.my_information_comment))

        override fun getCount(): Int = list.size

        override fun isViewFromObject(view: View, `object`: Any): Boolean = (view == `object`)

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val binding = NoDataDefaultLayoutBinding.inflate(getInflater(), container, false)
            container.addView(binding.root)
            return binding.root
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun getPageTitle(position: Int): CharSequence? = list[position]
    }

}