package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.DefaultEmptyRecyclerViewItemBinding

class DefaultEmptyRecyclerViewAdapter : RecyclerView.Adapter<DefaultEmptyRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DefaultEmptyRecyclerViewItemBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class ViewHolder(val binding: DefaultEmptyRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

}