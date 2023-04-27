package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.controller.simulate.CholestasisSimulateController
import cn.quibbler.lottery.controller.simulate.InheritanceSimulateController
import cn.quibbler.lottery.controller.simulate.NormalSimulateController
import cn.quibbler.lottery.controller.simulate.RandomSimulateController
import cn.quibbler.lottery.databinding.SimulateCholestasisLayoutBinding
import cn.quibbler.lottery.databinding.SimulateInheritanceLayoutBinding
import cn.quibbler.lottery.databinding.SimulateNormalLayoutBinding
import cn.quibbler.lottery.databinding.SimulateRandomLayoutBinding
import cn.quibbler.lottery.utils.getAppString

class SimulatePageAdapter : PagerAdapter() {

    private val list = arrayOf(
        getAppString(R.string.simulate_type_inheritance),
        getAppString(R.string.simulate_type_normal),
        getAppString(R.string.simulate_type_random),
        getAppString(R.string.simulate_type_cholestasis)
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val controller: Controller = when (position) {
            0 -> {
                InheritanceSimulateController(SimulateInheritanceLayoutBinding.inflate(LotteryApplication.layoutInflater, container, true))
            }
            1 -> {
                NormalSimulateController(SimulateNormalLayoutBinding.inflate(LotteryApplication.layoutInflater, container, true))
            }
            2 -> {
                RandomSimulateController(SimulateRandomLayoutBinding.inflate(LotteryApplication.layoutInflater, container, true))
            }
            else -> {
                CholestasisSimulateController(SimulateCholestasisLayoutBinding.inflate(LotteryApplication.layoutInflater, container, true))
            }
        }
        return controller.getView()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getPageTitle(position: Int): CharSequence = list[position]

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

}