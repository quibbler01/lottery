package cn.quibbler.lottery.controller.page

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.AdapterView
import cn.quibbler.lottery.LotteryApplication
import cn.quibbler.lottery.R
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.ViewPageSelfBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.MyCardAdapter
import cn.quibbler.lottery.ui.adapter.MyWealthCardAdapter
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.launcher.ARouter

class SelfPageController : Controller {

    private val binding = ViewPageSelfBinding.inflate(LotteryApplication.getInflater())

    init {
        val wealthCardAdapter = MyWealthCardAdapter()
        binding.myWealthCard.adapter = wealthCardAdapter

        val cardAdapter = MyCardAdapter()
        binding.myAllCard.adapter = cardAdapter

        binding.myAllCard.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = cardAdapter.getItem(position)
                ARouter.getInstance()
                        .build(item.routePath)
                        .withString(RouterCenter.argument_title, item.label)
                        .navigation()
            }
        }
    }

    override fun getView(): View = binding.root

    override fun getDescription(): String? = getAppString(R.string.tab_label_my)

    override fun getDrawableIcon(selected: Boolean): Drawable? = if (selected) {
        getAppDrawable(R.drawable.tab_my_selected)
    } else {
        getAppDrawable(R.drawable.tab_my_unselected)
    }

}