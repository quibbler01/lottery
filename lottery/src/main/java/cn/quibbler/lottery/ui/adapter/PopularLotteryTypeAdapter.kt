package cn.quibbler.lottery.ui.adapter

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.PopularInnerCardTypeRecyclerItemBinding
import cn.quibbler.lottery.databinding.PopularLotteryTypeRecyclerItemBinding

class PopularLotteryTypeAdapter : RecyclerView.Adapter<PopularLotteryTypeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PopularLotteryTypeRecyclerItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.recyclerView.adapter = holder.adapterFirst
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: PopularLotteryTypeRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val clickListener = View.OnClickListener {
            when (it?.id) {
                binding.winningList.id -> {
                    binding.winningList.setTextColor(binding.root.context.resources.getColor(R.color.red_num, null))
                    binding.bonusList.setTextColor(Color.parseColor("#B3000000"))
                    binding.popularityChart.setTextColor(Color.parseColor("#B3000000"))

                    binding.winningList.setBackgroundResource(R.drawable.white_bg_with_corner)
                    binding.bonusList.background = null
                    binding.popularityChart.background = null

                    binding.recyclerView.adapter = adapterFirst
                }
                binding.bonusList.id -> {
                    binding.winningList.setTextColor(Color.parseColor("#B3000000"))
                    binding.bonusList.setTextColor(binding.root.context.resources.getColor(R.color.red_num, null))
                    binding.popularityChart.setTextColor(Color.parseColor("#B3000000"))

                    binding.winningList.background = null
                    binding.bonusList.setBackgroundResource(R.drawable.white_bg_with_corner)
                    binding.popularityChart.background = null

                    binding.recyclerView.adapter = adapterSecond
                }
                binding.popularityChart.id -> {
                    binding.winningList.setTextColor(Color.parseColor("#B3000000"))
                    binding.bonusList.setTextColor(Color.parseColor("#B3000000"))
                    binding.popularityChart.setTextColor(binding.root.context.resources.getColor(R.color.red_num, null))

                    binding.winningList.background = null
                    binding.bonusList.background = null
                    binding.popularityChart.setBackgroundResource(R.drawable.white_bg_with_corner)

                    binding.recyclerView.adapter = adapterThird
                }
            }
        }

        val adapterFirst = CardRecyclerViewAdapter(ArrayList<CardRecyclerViewAdapter.Bean>().apply {
            add(CardRecyclerViewAdapter.Bean("上期中", "一等奖", "发哥"))
            add(CardRecyclerViewAdapter.Bean("上期中", "二等奖", "猴子"))
            add(CardRecyclerViewAdapter.Bean("上期中", "特等奖", "朵朵"))
            add(CardRecyclerViewAdapter.Bean("上期中", "5+1", "思齐"))
        })
        val adapterSecond = CardRecyclerViewAdapter(ArrayList<CardRecyclerViewAdapter.Bean>().apply {
            add(CardRecyclerViewAdapter.Bean("总奖金", "6820万", "钱孙"))
            add(CardRecyclerViewAdapter.Bean("总奖金", "5363万", "孙工"))
            add(CardRecyclerViewAdapter.Bean("总奖金", "2345万", "张伟"))
            add(CardRecyclerViewAdapter.Bean("总奖金", "6752万", "李四"))
            add(CardRecyclerViewAdapter.Bean("总奖金", "5563万", "张三"))
        })
        val adapterThird = CardRecyclerViewAdapter(ArrayList<CardRecyclerViewAdapter.Bean>().apply {
            add(CardRecyclerViewAdapter.Bean("人气值", "2315", "奥斑马"))
            add(CardRecyclerViewAdapter.Bean("人气值", "12454", "大圣"))
            add(CardRecyclerViewAdapter.Bean("人气值", "6125", "玛丽"))
            add(CardRecyclerViewAdapter.Bean("人气值", "9763", "王者"))
            add(CardRecyclerViewAdapter.Bean("人气值", "4265", "德玛"))
            add(CardRecyclerViewAdapter.Bean("人气值", "6723", "胡斯"))
        })

        init {
            binding.winningList.setOnClickListener(clickListener)
            binding.bonusList.setOnClickListener(clickListener)
            binding.popularityChart.setOnClickListener(clickListener)
        }

    }

    class CardRecyclerViewAdapter(val list: List<Bean> = ArrayList()) : RecyclerView.Adapter<CardRecyclerViewAdapter.ViewHolder>() {

        data class Bean(val title: String, val content: String = "", val name: String = "")

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = PopularInnerCardTypeRecyclerItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.binding.title.text = item.title
            holder.binding.content.text = item.content
            holder.binding.name.text = item.name
        }

        override fun getItemCount(): Int = list.size

        class ViewHolder(val binding: PopularInnerCardTypeRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    }

}