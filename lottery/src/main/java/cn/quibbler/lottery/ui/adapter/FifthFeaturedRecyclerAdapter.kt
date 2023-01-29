package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getApplicationContext
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.FifthRecyclerItemBinding
import cn.quibbler.lottery.databinding.LotterySevenNumsItemBinding
import cn.quibbler.lottery.model.Repository
import cn.quibbler.lottery.model.bean.LotteryItem

class FifthFeaturedRecyclerAdapter : RecyclerView.Adapter<FifthFeaturedRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FifthRecyclerItemBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.recycler.layoutManager = LinearLayoutManager(getApplicationContext())
        holder.binding.recycler.adapter = FeatureRecyclerAdapter()
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: FifthRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    /**
     * suggestion feature lottery
     */
    private class FeatureRecyclerAdapter : RecyclerView.Adapter<FeatureRecyclerAdapter.ViewHolder>() {

        private val list = ArrayList<LotteryItem>()

        init {
            for (i in 0 until 3) {
                list.add(Repository.getLotteryItem())
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding: LotterySevenNumsItemBinding = LotterySevenNumsItemBinding.inflate(getInflater(), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.binding.redNumOne.text = item.num1
            holder.binding.redNumTwo.text = item.num2
            holder.binding.redNumThree.text = item.num3
            holder.binding.redNumFour.text = item.num4
            holder.binding.redNumFive.text = item.num5
            holder.binding.blueNumOne.text = item.pre1
            holder.binding.blueNumTwo.text = item.pre2
        }

        override fun getItemCount(): Int = list.size

        class ViewHolder(val binding: LotterySevenNumsItemBinding) : RecyclerView.ViewHolder(binding.root)
    }

}