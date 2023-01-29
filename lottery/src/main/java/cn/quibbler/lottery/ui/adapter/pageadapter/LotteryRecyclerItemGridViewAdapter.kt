package cn.quibbler.lottery.ui.adapter.pageadapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getApplicationContext
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.LotteryGridViewItemBinding

class LotteryRecyclerItemGridViewAdapter : BaseAdapter() {

    private val list = getApplicationContext().resources.getStringArray(R.array.lottery_grid_items)

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): String = list[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: LotteryGridViewItemBinding
        if (convertView == null) {
            binding = LotteryGridViewItemBinding.inflate(getInflater(), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as LotteryGridViewItemBinding
        }
        binding.label.text = list[position]
        return binding.root
    }

}