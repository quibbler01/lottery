package cn.quibbler.lottery.controller.decoratecenter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.DynamicBackgroundCardViewPageBinding
import cn.quibbler.lottery.ui.adapter.DynamicBackgroundRecyclerAdapter

class DynamicBackgroundCardController(private val binding: DynamicBackgroundCardViewPageBinding) : Controller {

    private val layoutManager = GridLayoutManager(LotteryApplication.application, 2)

    private val adapter = DynamicBackgroundRecyclerAdapter()

    private val clickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            val currentChoosePos = v?.tag as Int? ?: return
            val preChoosePos = adapter.currentChoosePosition

            adapter.currentChoosePosition = currentChoosePos

            adapter.notifyItemChanged(currentChoosePos)
            preChoosePos?.let {
                adapter.notifyItemChanged(it)
            }

            if (preChoosePos != 0 && currentChoosePos == 0) {
                binding.saveChangeTextButton.isEnabled = false
                binding.saveChangeTextButton.setBackgroundResource(R.drawable.save_change_disable_bg)
            } else {
                binding.saveChangeTextButton.isEnabled = true
                binding.saveChangeTextButton.setBackgroundResource(R.drawable.save_change_enable_bg)
            }
        }
    }

    init {
        initView()
    }

    private fun initView() {
        binding.backgroundRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val pos = parent.getChildAdapterPosition(view)
                val row = pos / layoutManager.spanCount
                if (row > 0) {
                    outRect.set(0, 30, 0, 0)
                }
            }
        })
        binding.backgroundRecyclerView.layoutManager = layoutManager
        adapter.clickListener = clickListener
        binding.backgroundRecyclerView.adapter = adapter
    }

    override fun getView(): View = binding.root

}