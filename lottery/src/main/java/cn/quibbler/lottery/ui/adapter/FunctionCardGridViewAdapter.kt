package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.FunctionGridViewItemBinding
import cn.quibbler.lottery.model.bean.FunctionItem
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class FunctionCardGridViewAdapter : BaseAdapter() {

    private val functionList = ArrayList<FunctionItem>()

    init {
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_bounce), getAppDrawable(R.drawable.function_card_open_bounce)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_recommend), getAppDrawable(R.drawable.function_card_recommend)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_game_center), getAppDrawable(R.drawable.function_card_game_center)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_trend), getAppDrawable(R.drawable.function_card_trend)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_scan), getAppDrawable(R.drawable.function_card_scan)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_choose), getAppDrawable(R.drawable.function_card_choose)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_analyze), getAppDrawable(R.drawable.function_card_analyze)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_pick), getAppDrawable(R.drawable.function_card_pick)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_rainbow), getAppDrawable(R.drawable.function_card_rainbow)))
        functionList.add(FunctionItem(getAppString(R.string.function_card_label_simulate), getAppDrawable(R.drawable.function_card_simulate)))
    }

    override fun getCount(): Int = functionList.size

    override fun getItem(position: Int): FunctionItem = functionList[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: FunctionGridViewItemBinding
        if (convertView == null) {
            binding = FunctionGridViewItemBinding.inflate(cn.quibbler.lottery.LotteryApplication.Companion.getInflater(), parent, false)
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