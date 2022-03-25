package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.FirstBannerRecyclerItemBinding
import cn.quibbler.lottery.ui.adapter.pageadapter.BannerViewPagerAdapter

class FirstBannerRecyclerAdapter : RecyclerView.Adapter<FirstBannerRecyclerAdapter.ViewHolder>() {

    private val adapter = BannerViewPagerAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FirstBannerRecyclerItemBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewPager.adapter = adapter
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: FirstBannerRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}