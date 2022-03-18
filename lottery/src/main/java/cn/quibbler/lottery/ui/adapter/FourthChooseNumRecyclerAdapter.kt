package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.FourthTwoCardRecyclerItemBinding

class FourthChooseNumRecyclerAdapter : RecyclerView.Adapter<FourthChooseNumRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FourthTwoCardRecyclerItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: FourthTwoCardRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}