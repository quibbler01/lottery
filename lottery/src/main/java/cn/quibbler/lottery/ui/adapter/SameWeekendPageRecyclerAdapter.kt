package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.SameWeekendPageRecyclerFirstItemBinding
import cn.quibbler.lottery.databinding.SameWeekendPageRecyclerItemBinding

class SameWeekendPageRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val first_type = 0
        const val normal_type = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            first_type -> {
                val binding = SameWeekendPageRecyclerFirstItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
                ViewHolderHead(binding)
            }
            normal_type -> {
                val binding = SameWeekendPageRecyclerItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
                ViewHolder(binding)
            }
            else -> {
                throw IllegalStateException("unknown type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.binding.sequenceNumber.text = position.toString()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                first_type
            }
            else -> {
                normal_type
            }
        }
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class ViewHolderHead(val binding: SameWeekendPageRecyclerFirstItemBinding) : RecyclerView.ViewHolder(binding.root)

    class ViewHolder(val binding: SameWeekendPageRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

}