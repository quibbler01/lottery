package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.ThirdGridCaardRecyclerItemBinding

class ThirdCardRecyclerAdapter : RecyclerView.Adapter<ThirdCardRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ThirdGridCaardRecyclerItemBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.gridView.adapter = FunctionCardGridViewAdapter()
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: ThirdGridCaardRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}