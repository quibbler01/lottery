package cn.quibbler.lottery.ui.activity.toolsui

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityRainbowBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.function_rainbow_activity)
class RainbowActivity : BaseActivity() {

    private lateinit var binding: ActivityRainbowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRainbowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}