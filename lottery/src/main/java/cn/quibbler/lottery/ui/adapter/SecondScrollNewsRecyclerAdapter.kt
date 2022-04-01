package cn.quibbler.lottery.ui.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getContext
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.SecondScrollTextRecyclerItemBinding
import cn.quibbler.lottery.utils.TextSwitcherAnimation

class SecondScrollNewsRecyclerAdapter : RecyclerView.Adapter<SecondScrollNewsRecyclerAdapter.ViewHolder>() {

    private val list: ArrayList<String> = ArrayList()
    private var switcherAnnotation: TextSwitcherAnimation? = null

    init {
        val l = getContext().resources.getStringArray(R.array.scroll_text_list)
        for (i in l) {
            list.add(i)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SecondScrollTextRecyclerItemBinding.inflate(getInflater(), parent, false)
        binding.textSwitcher.setFactory {
            val textView = TextView(parent.context)
            textView.setTextAppearance(R.style.text_switcher_style)
            textView
        }
        switcherAnnotation = TextSwitcherAnimation(binding.textSwitcher, list)
        switcherAnnotation?.create()
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: SecondScrollTextRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    public fun release() {
        switcherAnnotation?.end()
    }

}