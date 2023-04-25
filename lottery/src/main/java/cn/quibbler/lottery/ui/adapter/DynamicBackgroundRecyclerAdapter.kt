package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.DynamicBackgroundRecyclerItemBinding
import cn.quibbler.lottery.model.bean.DynamicBackgroundItem

class DynamicBackgroundRecyclerAdapter : RecyclerView.Adapter<DynamicBackgroundRecyclerAdapter.ViewHolder>() {

    var clickListener: View.OnClickListener? = null

    var currentChoosePosition: Int? = null

    private val list = ArrayList<DynamicBackgroundItem>().apply {
        add(DynamicBackgroundItem("无背景", false))
        add(DynamicBackgroundItem("先中一个亿", true))
        add(DynamicBackgroundItem("日进斗金", true))
        add(DynamicBackgroundItem("上上签", true))
        add(DynamicBackgroundItem("大吉大利", false))
        add(DynamicBackgroundItem("彩票人", false))
        add(DynamicBackgroundItem("好运连连", false))
        add(DynamicBackgroundItem("中奖体质", false))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DynamicBackgroundRecyclerItemBinding.inflate(LotteryApplication.layoutInflater, parent, false)
        binding.container.setOnClickListener(clickListener)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.container.tag = position
        holder.binding.title.text = item.title
        if (item.isMemberOnly) {
            holder.binding.memberOnlyIcon.visibility = View.VISIBLE
        } else {
            holder.binding.memberOnlyIcon.visibility = View.GONE
        }
        if (position == currentChoosePosition) {
            holder.binding.container.setBackgroundResource(R.drawable.avatar_pendant_select_bg)
        } else {
            holder.binding.container.setBackgroundResource(R.drawable.avatar_pendant_unselect_bg)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: DynamicBackgroundRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

}