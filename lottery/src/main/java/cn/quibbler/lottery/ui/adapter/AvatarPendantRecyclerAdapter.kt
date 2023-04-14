package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.AvatarPendantRecyclerItemBinding
import cn.quibbler.lottery.model.bean.AvatarPendantItem

class AvatarPendantRecyclerAdapter : RecyclerView.Adapter<AvatarPendantRecyclerAdapter.ViewHolder>() {

    var clickListener: View.OnClickListener? = null

    var currentChoosePosition: Int? = null

    private val list = ArrayList<AvatarPendantItem>().apply {
        add(AvatarPendantItem("无挂件", false))
        add(AvatarPendantItem("财神附体", true))
        add(AvatarPendantItem("上岸锦鲤", true))
        add(AvatarPendantItem("一夜暴富", true))
        add(AvatarPendantItem("兔然暴富", false))
        add(AvatarPendantItem("鸿运当头", false))
        add(AvatarPendantItem("守号专家", false))
        add(AvatarPendantItem("机选大师", false))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AvatarPendantRecyclerItemBinding.inflate(LotteryApplication.layoutInflater, parent, false)
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

    class ViewHolder(val binding: AvatarPendantRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

}