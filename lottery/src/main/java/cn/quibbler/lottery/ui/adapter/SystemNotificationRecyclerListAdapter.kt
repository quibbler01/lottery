package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.SystemNotificationItemBinding
import cn.quibbler.lottery.model.bean.NotificationBean

class SystemNotificationRecyclerListAdapter : RecyclerView.Adapter<SystemNotificationRecyclerListAdapter.ViewHolder>() {

    private val systemNotificationList = ArrayList<NotificationBean>().apply {
        add(NotificationBean("七乐彩2023037期开奖结果[02 03 13 14 18 25 30 + 28]，点击查看详情",1L))
        add(NotificationBean("福彩3D2023085期开奖结果[568]，点击查看详情",1L))
        add(NotificationBean("超级大乐透2023037期开奖结果[06 08 16 20 24 + 07 08]，点击查看详情",1L))
        add(NotificationBean("快乐82023085期开奖结果[06 10 11 15 26 28 30 34 36 38 50 53 57 59 61 65 70 71 73 79]，点击查看详情",1L))
        add(NotificationBean("排列32023085期开奖结果[557]，点击查看详情",1L))
        add(NotificationBean("双色球2023038期开奖结果[02 09 14 17 31 33 + 08]，点击查看详情",1L))
        add(NotificationBean("福彩3D2023086期开奖结果[143]，点击查看详情",1L))
        add(NotificationBean("排列32023086期开奖结果[915]，点击查看详情",1L))
        add(NotificationBean("排列52023086期开奖结果[91550]，点击查看详情",1L))
        add(NotificationBean("快乐82023086期开奖结果[05 09 12 19 21 22 28 34 41 45 46 49 50 56 64 65 68 69 70 75]，点击查看详情",1L))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SystemNotificationItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            this.notificationContent.text = systemNotificationList[position].content
        }
    }

    override fun getItemCount(): Int = systemNotificationList.size

    class ViewHolder(val binding: SystemNotificationItemBinding) : RecyclerView.ViewHolder(binding.root)

}