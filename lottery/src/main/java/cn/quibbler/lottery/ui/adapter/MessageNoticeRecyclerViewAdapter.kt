package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.MessageNoticeRecyclerViewItemBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.bean.MessageNoticeTypeItem
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.launcher.ARouter

class MessageNoticeRecyclerViewAdapter : RecyclerView.Adapter<MessageNoticeRecyclerViewAdapter.ViewHolder>() {

    private val list = ArrayList<MessageNoticeTypeItem>().apply {
        add(
            MessageNoticeTypeItem(
                getAppString(R.string.message_title_comment),
                R.drawable.message_comment_icon,
                RouterCenter.message_activity_comment,
                getAppString(R.string.message_titlearg_comment)
            )
        )
        add(
            MessageNoticeTypeItem(
                getAppString(R.string.message_title_thumb),
                R.drawable.message_thumb_icon,
                RouterCenter.message_activity_thumbs,
                getAppString(R.string.message_titlearg_thumbs)
            )
        )
        add(
            MessageNoticeTypeItem(
                getAppString(R.string.message_title_dot),
                R.drawable.message_dot_icon,
                RouterCenter.message_activity_dot,
                getAppString(R.string.message_titlearg_dot)
            )
        )
        add(
            MessageNoticeTypeItem(
                getAppString(R.string.message_title_fans),
                R.drawable.message_fans_icon,
                RouterCenter.message_activity_new_fans,
                getAppString(R.string.message_titlearg_fans)
            )
        )
    }

    private val clickListener = View.OnClickListener {
        val pos = it.tag as Int
        val item = list[pos]
        ARouter.getInstance()
            .build(item.path)
            .withString(RouterCenter.argument_title, item.titleArg)
            .navigation()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MessageNoticeRecyclerViewItemBinding.inflate(LotteryApplication.layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.messageTitle.text = item.title
        holder.binding.messageIcon.setImageResource(item.resIcon)

        holder.binding.root.tag = position
        holder.binding.root.setOnClickListener(clickListener)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: MessageNoticeRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

}