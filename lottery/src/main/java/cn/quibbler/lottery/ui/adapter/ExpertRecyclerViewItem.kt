package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.ExpertRecyclerViewItemBinding
import cn.quibbler.lottery.model.Repository
import com.robinhood.ticker.TickerUtils

class ExpertRecyclerViewItem : RecyclerView.Adapter<ExpertRecyclerViewItem.ViewHolder>() {

    private val list = Repository.getHistoryOpenLottery()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExpertRecyclerViewItemBinding.inflate(getInflater(), parent, false)
        binding.countDownHour.setCharacterLists(TickerUtils.provideNumberList())
        binding.countDownMinutes.setCharacterLists(TickerUtils.provideNumberList())
        binding.countDownSeconds.setCharacterLists(TickerUtils.provideNumberList())
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.num.text = "${item.num}期"
        holder.binding.costDiamond.text = Repository.getCost(38).toString()

        holder.binding.countDownHour.text = "02"
        holder.binding.countDownMinutes.text = "19"
        holder.binding.countDownSeconds.text = "39"
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: ExpertRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

}