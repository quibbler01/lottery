package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.HistoryOpenLotteryRecyclerItemBinding

class HistoryOpenLotteryRecyclerAdapter : RecyclerView.Adapter<HistoryOpenLotteryRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HistoryOpenLotteryRecyclerItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class ViewHolder(val binding: HistoryOpenLotteryRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

}