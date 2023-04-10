package cn.quibbler.lottery.controller.decoratecenter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.AvatarPendantViewPageBinding
import cn.quibbler.lottery.ui.adapter.AvatarPendantRecyclerAdapter

class AvatarController(private val binding: AvatarPendantViewPageBinding) : Controller {

    private val layoutManager = GridLayoutManager(LotteryApplication.application, 3)

    private val adapter = AvatarPendantRecyclerAdapter()

    private val clickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            val currentChoosePos = v?.tag as Int? ?: return
            val preChoosePos: Int? = adapter.currentChoosePosition

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
        adapter.clickListener = clickListener
        binding.pendantRecyclerView.layoutManager = layoutManager
        binding.pendantRecyclerView.adapter = adapter
        binding.pendantRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val pos = parent.getChildAdapterPosition(view)
                val row = pos / layoutManager.spanCount
                if (row > 0) {
                    outRect.set(0, 20, 0, 0)
                }
            }
        })
    }

    override fun getView(): View = binding.root

}