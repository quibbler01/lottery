package cn.quibbler.lottery.ui.adapter.communityadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.CommunityRecommendFunctionBinding

class CommunityFunctionAdapter : RecyclerView.Adapter<CommunityFunctionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CommunityRecommendFunctionBinding.inflate(LotteryApplication.layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: CommunityRecommendFunctionBinding) : RecyclerView.ViewHolder(binding.root)

}