package cn.quibbler.lottery.controller.simulate

import android.view.View
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.SimulateInheritanceLayoutBinding
import cn.quibbler.lottery.databinding.SimulateNormalLayoutBinding

class NormalSimulateController(val binding: SimulateNormalLayoutBinding) : Controller {

    override fun getView(): View = binding.root

}