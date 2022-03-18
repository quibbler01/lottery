package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.DefaultEmptyRecyclerViewItemBinding

class DefaultEmptyRecyclerViewAdapter : RecyclerView.Adapter<DefaultEmptyRecyclerViewAdapter.ViewHolder>() {

    private val size = 30

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DefaultEmptyRecyclerViewItemBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = size

    class ViewHolder(val binding: DefaultEmptyRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

}