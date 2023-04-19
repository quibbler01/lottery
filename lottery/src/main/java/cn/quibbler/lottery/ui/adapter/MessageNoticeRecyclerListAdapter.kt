package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.MessageNoticeRecyclerItemBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.bean.MessageNoticeListItem
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.launcher.ARouter

class MessageNoticeRecyclerListAdapter : RecyclerView.Adapter<MessageNoticeRecyclerListAdapter.ViewHolder>() {

    private val list = ArrayList<MessageNoticeListItem>().apply {
        add(
            MessageNoticeListItem(
                getAppString(R.string.system_notification),
                RouterCenter.self_activity_system_notification,
                R.drawable.system_notification_icon
            )
        )
        add(
            MessageNoticeListItem(
                getAppString(R.string.violation_notification),
                RouterCenter.self_activity_violation_notification,
                R.drawable.violation_notification_icon
            )
        )
        add(
            MessageNoticeListItem(
                getAppString(R.string.other_notification),
                RouterCenter.self_activity_other_notification,
                R.drawable.about_notification_icon
            )
        )
    }

    private val clickListener = View.OnClickListener {
        val pos = it.tag as Int
        val item = list[pos]
        ARouter.getInstance()
            .build(item.routePath)
            .withString(RouterCenter.argument_title, item.title)
            .navigation()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MessageNoticeRecyclerItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
        binding.systemNotificationView.setOnClickListener(clickListener)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.systemNotificationView.tag = position
        holder.binding.systemNotificationTitle.text = item.title
        holder.binding.systemNotificationIcon.setImageResource(item.drawableInt)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: MessageNoticeRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)


}