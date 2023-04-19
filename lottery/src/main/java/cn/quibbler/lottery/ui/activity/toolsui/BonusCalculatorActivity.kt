package cn.quibbler.lottery.ui.activity.toolsui

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityBonusCalculatorBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.bonus_calculator_activity)
class BonusCalculatorActivity : BaseActivity() {

    private lateinit var binding: ActivityBonusCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBonusCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}