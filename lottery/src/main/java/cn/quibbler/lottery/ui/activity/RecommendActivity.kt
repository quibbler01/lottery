package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.ActivityRecommendBinding
import cn.quibbler.lottery.databinding.RecommendItemLayoutBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.function_recommend_activity)
class RecommendActivity : BaseActivity() {

    private lateinit var binding: ActivityRecommendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecommendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecommendAdapter()
    }

    private class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding: RecommendItemLayoutBinding = RecommendItemLayoutBinding.inflate(getInflater(), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        }

        override fun getItemCount(): Int = 12

        class ViewHolder(val binding: RecommendItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        }

    }

}