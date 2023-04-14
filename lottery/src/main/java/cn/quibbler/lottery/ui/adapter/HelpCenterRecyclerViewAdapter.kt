package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.HelpCenterItemItemBinding
import cn.quibbler.lottery.databinding.HelpCenterTitleItemBinding
import cn.quibbler.lottery.model.bean.HelpCenterRecyclerItem

class HelpCenterRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_ITEM = 1

        val helpList = ArrayList<HelpCenterRecyclerItem>().apply {
            add(HelpCenterRecyclerItem("社区相关问题", true))
            add(HelpCenterRecyclerItem("广告反馈", false))
            add(HelpCenterRecyclerItem("发言不显示，发不出去怎么办", false))
            add(HelpCenterRecyclerItem("社区发言规则", false))

            add(HelpCenterRecyclerItem("APP功能", true))
            add(HelpCenterRecyclerItem("大师精析功能介绍", false))
            add(HelpCenterRecyclerItem("会员是什么", false))
            add(HelpCenterRecyclerItem("如何模拟选号", false))

            add(HelpCenterRecyclerItem("账户相关问题", true))
            add(HelpCenterRecyclerItem("彩虹多多支付密码是什么", false))
            add(HelpCenterRecyclerItem("禁言怎么办", false))
            add(HelpCenterRecyclerItem("如何进行实名认证", false))

            add(HelpCenterRecyclerItem("通用", true))
            add(HelpCenterRecyclerItem("彩钻、彩豆分别是什么", false))
            add(HelpCenterRecyclerItem("彩虹多多平台介绍", false))
            add(HelpCenterRecyclerItem("客服工作时间", false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = helpList[position]
        return if (item.isTitle) TYPE_TITLE else TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TITLE -> {
                TitleViewHolder(HelpCenterTitleItemBinding.inflate(LotteryApplication.layoutInflater, parent, false))
            }
            else -> {
                ItemViewHolder(HelpCenterItemItemBinding.inflate(LotteryApplication.layoutInflater, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = helpList[position]
        when (getItemViewType(position)) {
            TYPE_TITLE -> {
                (holder as TitleViewHolder).apply {
                    this.binding.title.text = item.title
                }
            }
            TYPE_ITEM -> {
                (holder as ItemViewHolder).apply {
                    this.binding.content.text = item.title
                }
            }
        }
    }

    override fun getItemCount(): Int = helpList.size

    class TitleViewHolder(val binding: HelpCenterTitleItemBinding) : RecyclerView.ViewHolder(binding.root)

    class ItemViewHolder(val binding: HelpCenterItemItemBinding) : RecyclerView.ViewHolder(binding.root)

}