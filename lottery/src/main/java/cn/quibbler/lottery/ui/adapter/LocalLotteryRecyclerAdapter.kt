package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.LocalLotteryRecyclerItemBinding

class LocalLotteryRecyclerAdapter : RecyclerView.Adapter<LocalLotteryRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LocalLotteryRecyclerItemBinding = LocalLotteryRecyclerItemBinding.inflate(LotteryApplication.layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class ViewHolder(val binding: LocalLotteryRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

}