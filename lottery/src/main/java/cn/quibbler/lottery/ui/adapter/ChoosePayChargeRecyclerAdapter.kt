package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ChargeChooseRecyclerItemBinding
import cn.quibbler.lottery.utils.getColor

class ChoosePayChargeRecyclerAdapter() : RecyclerView.Adapter<ChoosePayChargeRecyclerAdapter.ViewHolder>() {

    val listOfCharge = arrayOf(88, 128, 388, 628, 1288, 2388)

    var currentChoosePos = 0

    var clickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ChargeChooseRecyclerItemBinding.inflate(LotteryApplication.layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.chargeNumber.text = listOfCharge[position].toString()
        holder.binding.payNumber.text = "￥${listOfCharge[position]}"
        if (position == currentChoosePos) {
            holder.binding.chargeIconChooseCorner.visibility = View.VISIBLE
            holder.binding.chooseContainer.setBackgroundResource(R.drawable.charge_choosed_list_item)
            holder.binding.payNumber.setTextColor(getColor(R.color.red_num))
        } else {
            holder.binding.chargeIconChooseCorner.visibility = View.GONE
            holder.binding.chooseContainer.setBackgroundResource(R.drawable.charge_choose_list_item)
            holder.binding.payNumber.setTextColor(getColor(R.color.black))
        }
        holder.binding.chooseContainer.tag = position
        holder.binding.chooseContainer.setOnClickListener(clickListener)
    }

    override fun getItemCount(): Int = listOfCharge.size

    class ViewHolder(val binding: ChargeChooseRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

}