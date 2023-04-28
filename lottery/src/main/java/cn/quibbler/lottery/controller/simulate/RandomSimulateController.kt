package cn.quibbler.lottery.controller.simulate

import android.view.View
import cn.quibbler.lottery.controller.Controller
import cn.quibbler.lottery.databinding.SimulateInheritanceLayoutBinding
import cn.quibbler.lottery.databinding.SimulateRandomLayoutBinding

class RandomSimulateController(val binding: SimulateRandomLayoutBinding) : Controller {

    override fun getView(): View = binding.root

}