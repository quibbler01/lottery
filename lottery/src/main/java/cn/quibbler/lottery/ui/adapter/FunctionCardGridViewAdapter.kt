package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.FunctionGridViewItemBinding
import cn.quibbler.lottery.model.RouterCenter.function_analyze_activity
import cn.quibbler.lottery.model.RouterCenter.function_choose_activity
import cn.quibbler.lottery.model.RouterCenter.function_game_center_activity
import cn.quibbler.lottery.model.RouterCenter.function_open_bounce_activity
import cn.quibbler.lottery.model.RouterCenter.function_pick_activity
import cn.quibbler.lottery.model.RouterCenter.function_rainbow_activity
import cn.quibbler.lottery.model.RouterCenter.function_recommend_activity
import cn.quibbler.lottery.model.RouterCenter.function_scan_activity
import cn.quibbler.lottery.model.RouterCenter.function_simulate_activity
import cn.quibbler.lottery.model.RouterCenter.function_trend_activity
import cn.quibbler.lottery.model.bean.FunctionItem
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class FunctionCardGridViewAdapter : BaseAdapter() {

    private val functionList = ArrayList<FunctionItem>()

    init {
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_recommend), function_recommend_activity, getAppDrawable(R.drawable.function_card_recommend)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_bounce), function_open_bounce_activity, getAppDrawable(R.drawable.function_card_open_bounce)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_game_center), function_game_center_activity, getAppDrawable(R.drawable.function_card_game_center)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_trend), function_trend_activity, getAppDrawable(R.drawable.function_card_trend)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_scan), function_scan_activity, getAppDrawable(R.drawable.function_card_scan)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_choose), function_choose_activity, getAppDrawable(R.drawable.function_card_choose)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_analyze), function_analyze_activity, getAppDrawable(R.drawable.function_card_analyze)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_pick), function_pick_activity, getAppDrawable(R.drawable.function_card_pick)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_rainbow), function_rainbow_activity, getAppDrawable(R.drawable.function_card_rainbow)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_simulate), function_simulate_activity, getAppDrawable(R.drawable.function_card_simulate)))
    }

    override fun getCount(): Int = functionList.size

    override fun getItem(position: Int): FunctionItem = functionList[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: FunctionGridViewItemBinding
        if (convertView == null) {
            binding = FunctionGridViewItemBinding.inflate(getInflater(), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as FunctionGridViewItemBinding
        }

        val item = getItem(position)
        binding.label.text = item.label
        binding.image.setImageDrawable(item.icon)

        return binding.root
    }

}