package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.BeanStoreItemBinding
import cn.quibbler.lottery.model.bean.BeanStoreItem

class BeanStoreRecyclerListAdapter : RecyclerView.Adapter<BeanStoreRecyclerListAdapter.ViewHolder>() {

    private val listOfStore = ArrayList<BeanStoreItem>().apply {
        add(BeanStoreItem(800000, "20元京东E卡", R.drawable.my_settings_icon, 5))
        add(BeanStoreItem(400000, "10元京东E卡", R.drawable.my_settings_icon, 4))
        add(BeanStoreItem(2000000, "50元京东E卡", R.drawable.my_settings_icon, 1))
        add(BeanStoreItem(1000000, "头像挂件", R.drawable.my_settings_icon, 18))
        add(BeanStoreItem(1000000, "头像挂件", R.drawable.my_settings_icon, 3))
        add(BeanStoreItem(800000, "动态背景卡", R.drawable.my_settings_icon, 24))
        add(BeanStoreItem(800000, "动态背景卡", R.drawable.my_settings_icon, 20))
        add(BeanStoreItem(1200000, "SVIP3天体验卡", R.drawable.my_settings_icon, 1))
        add(BeanStoreItem(1200000, "SVIP3天体验卡", R.drawable.my_settings_icon, 5))
        add(BeanStoreItem(1200000, "SVIP3天体验卡", R.drawable.my_settings_icon, 1))
        add(BeanStoreItem(1200000, "SVIP3天体验卡", R.drawable.my_settings_icon, 9))
        add(BeanStoreItem(1200000, "SVIP3天体验卡", R.drawable.my_settings_icon, 2))
        add(BeanStoreItem(700000, "智能推荐免单券", R.drawable.my_settings_icon, 10))
        add(BeanStoreItem(1500000, "大师免单券", R.drawable.my_settings_icon, 5))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BeanStoreItemBinding.inflate(LotteryApplication.getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfStore[position]
        holder.binding.productCost.text = "${item.cost}彩豆"
        holder.binding.productRemainCount.text = "${item.remainCount}份"
        holder.binding.productIcon.setImageResource(item.drawableResId)
        holder.binding.productName.text = item.productName
    }

    override fun getItemCount(): Int = listOfStore.size

    class ViewHolder(val binding: BeanStoreItemBinding) : RecyclerView.ViewHolder(binding.root)

}