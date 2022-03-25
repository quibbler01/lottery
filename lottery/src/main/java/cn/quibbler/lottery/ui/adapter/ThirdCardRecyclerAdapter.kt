package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.ThirdGridCaardRecyclerItemBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.launcher.ARouter

class ThirdCardRecyclerAdapter : RecyclerView.Adapter<ThirdCardRecyclerAdapter.ViewHolder>() {

    private val adapter = FunctionCardGridViewAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ThirdGridCaardRecyclerItemBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.gridView.adapter = adapter
        holder.binding.gridView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = adapter.getItem(position)
                ARouter.getInstance().build(item.routePath)
                        .withString(RouterCenter.argument_title, item.label)
                        .navigation()
            }
        })
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: ThirdGridCaardRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}