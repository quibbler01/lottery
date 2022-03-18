package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.controller.Controller

class MainViewPagerAdapter(private val controllers: ArrayList<Controller>) : PagerAdapter() {

    override fun getCount(): Int = controllers.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = controllers[position].getView()
        container.addView(view)
        return controllers[position].getView()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = controllers[position].getView()
        container.removeView(view)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return controllers[position].getDescription()
    }

}