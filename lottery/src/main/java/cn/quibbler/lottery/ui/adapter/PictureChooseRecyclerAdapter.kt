package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.databinding.PictureChooseItemBinding

class PictureChooseRecyclerAdapter : RecyclerView.Adapter<PictureChooseRecyclerAdapter.ViewHolder>() {

    private val choosePictureList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PictureChooseItemBinding.inflate(LotteryApplication.layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == choosePictureList.size) {
            holder.binding.image.visibility = View.INVISIBLE
            holder.binding.addArea.visibility = View.VISIBLE
        } else {
            holder.binding.image.visibility = View.VISIBLE
            holder.binding.addArea.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int = choosePictureList.size + 1

    class ViewHolder(val binding: PictureChooseItemBinding) : RecyclerView.ViewHolder(binding.root)

}