package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityCenterBinding
import cn.quibbler.lottery.databinding.ActivityCenterRecyclerViewItemBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.bean.ActivityCenterItem
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_center)
class ActivityCenterActivity : BaseActivity() {

    private lateinit var binding: ActivityCenterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(LotteryApplication.getApplicationContext())
        binding.recyclerView.adapter = ActivityItemRecyclerViewAdapter()
    }

    private class ActivityItemRecyclerViewAdapter : RecyclerView.Adapter<ActivityItemRecyclerViewAdapter.ViewHolder>() {

        private val list = ArrayList<ActivityCenterItem>()

        init {
            list.add(ActivityCenterItem(getAppString(R.string.activity_center_title_1), getAppDrawable(R.drawable.activity_center_image_1)))
            list.add(ActivityCenterItem(getAppString(R.string.activity_center_title_2), getAppDrawable(R.drawable.activity_center_image_2)))
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ActivityCenterRecyclerViewItemBinding.inflate(getInflater(), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            holder.binding.activityTitle.text = item.title
            holder.binding.image.setImageDrawable(item.image)
        }

        override fun getItemCount(): Int = list.size

        class ViewHolder(val binding: ActivityCenterRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        }

    }

}