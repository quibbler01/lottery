package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.LotteryPageRecyclerViewItemBinding
import cn.quibbler.lottery.model.Repository
import cn.quibbler.lottery.model.bean.OpenLotteryItem
import cn.quibbler.lottery.repository.LoadCallback
import cn.quibbler.lottery.ui.adapter.pageadapter.LotteryRecyclerItemGridViewAdapter
import java.util.*
import kotlin.collections.ArrayList

class LotteryPageRecyclerViewAdapter : RecyclerView.Adapter<LotteryPageRecyclerViewAdapter.ViewHolder>() {

    private val gridAdapter = LotteryRecyclerItemGridViewAdapter()

    private val list = ArrayList<OpenLotteryItem>()

    init {
        list.addAll(Repository.requestData())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LotteryPageRecyclerViewItemBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.numOfLottery.text = item.num.toString()
        holder.binding.dateOfLottery.text = item.date.toString("yy-MM-dd", Locale.CHINESE)
        holder.binding.weekOfLottery.text = item.date.toString("EE", Locale.CHINESE)
        holder.binding.redNumOne.text = item.item.num1
        holder.binding.redNumTwo.text = item.item.num2
        holder.binding.redNumThree.text = item.item.num3
        holder.binding.redNumFour.text = item.item.num4
        holder.binding.redNumFive.text = item.item.num5
        holder.binding.blueNumOne.text = item.item.pre1
        holder.binding.blueNumTwo.text = item.item.pre2

        holder.binding.gridView.adapter = gridAdapter
    }

    override fun getItemCount(): Int = list.size

    public fun requestNextPageData(callback: LoadCallback) {
        val start = list.size
        val data = Repository.requestData(start)
        list.addAll(data)
        notifyItemRangeInserted(start, data.size)
        callback.onSuccess()
    }

    class ViewHolder(val binding: LotteryPageRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

}