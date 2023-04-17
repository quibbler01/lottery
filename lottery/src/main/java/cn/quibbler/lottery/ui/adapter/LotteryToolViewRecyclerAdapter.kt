package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getApplicationContext
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.MainController
import cn.quibbler.lottery.databinding.LotteryGridViewItemBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.bean.GridToolsItem
import com.alibaba.android.arouter.launcher.ARouter

class LotteryToolViewRecyclerAdapter : RecyclerView.Adapter<LotteryToolViewRecyclerAdapter.ViewHolder>() {

    private val list = ArrayList<GridToolsItem>().apply {
        val names = getApplicationContext().resources.getStringArray(R.array.lottery_grid_items)
        add(GridToolsItem(names[0], names[0], RouterCenter.historical_lottery_activity))
        add(GridToolsItem(names[1], names[1], RouterCenter.trend_chart_activity))
        add(GridToolsItem(names[2], names[2], null))
        add(GridToolsItem(names[3], names[3], RouterCenter.simulated_number_selection_activity))
        add(GridToolsItem(names[4], names[4], RouterCenter.bonus_calculator_activity))
        add(GridToolsItem(names[5], names[5], RouterCenter.vip_membership_activity))
        add(GridToolsItem(names[6], names[6], RouterCenter.data_statistics_activity))
        add(GridToolsItem(names[7], names[7], RouterCenter.trend_analysis_activity))
        add(GridToolsItem(names[8], names[8], RouterCenter.real_time_hotspots_activity))
        add(GridToolsItem(names[9], names[9], RouterCenter.moving_average_analysis_activity))
        add(GridToolsItem(names[10], names[10], RouterCenter.number_selection_distribution_activity))
        add(GridToolsItem(names[11], names[11], RouterCenter.omitted_treasure_activity))
    }

    private val clickListener = View.OnClickListener {
        val pos = it.tag as Int? ?: return@OnClickListener
        val item = list[pos]

        if (item.routePath != null) {
            ARouter.getInstance().build(item.routePath).withString(RouterCenter.argument_title, item.title).navigation()
        } else {
            MainController.selectPage(MainController.ExpertPagePOS)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LotteryGridViewItemBinding.inflate(getInflater(), parent, false)
        binding.root.setOnClickListener(clickListener)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root.tag = position
        holder.binding.label.text = list[position].name
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: LotteryGridViewItemBinding) : RecyclerView.ViewHolder(binding.root)

}