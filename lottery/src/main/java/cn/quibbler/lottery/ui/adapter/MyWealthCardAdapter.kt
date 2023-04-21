package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.WealthCardItemBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.bean.WealthItem
import cn.quibbler.lottery.model.bean.WealthItem.Companion.defaultWealthNum
import cn.quibbler.lottery.utils.getAppString

class MyWealthCardAdapter : BaseAdapter() {

    private val listOfWealth = ArrayList<WealthItem>()

    init {
        listOfWealth.add(WealthItem(defaultWealthNum, getAppString(R.string.my_wealth_colored_diamonds), RouterCenter.self_activity_charge, getAppString(R.string.recharge)))
        listOfWealth.add(WealthItem(defaultWealthNum, getAppString(R.string.my_wealth_colorful_bean), RouterCenter.self_activity_color_bean, getAppString(R.string.my_wealth_colorful_bean)))
        listOfWealth.add(WealthItem(defaultWealthNum, getAppString(R.string.my_wealth_incentive_money), RouterCenter.self_activity_incentive_money, getAppString(R.string.my_wealth_incentive_money)))
        listOfWealth.add(WealthItem(defaultWealthNum, getAppString(R.string.my_wealth_coupon), RouterCenter.self_activity_coupon, getAppString(R.string.my_coupon)))
    }

    override fun getCount(): Int = listOfWealth.size

    override fun getItem(position: Int): WealthItem = listOfWealth[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: WealthCardItemBinding
        if (convertView == null) {
            binding = WealthCardItemBinding.inflate(getInflater(), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as WealthCardItemBinding
        }

        val item = getItem(position)
        binding.wealthNum.text = if (item.wealthVal == defaultWealthNum) getAppString(R.string.default_wealth_num) else item.wealthVal.toString()
        binding.wealthLabel.text = item.label

        return binding.root
    }

}