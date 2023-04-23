package cn.quibbler.lottery.ui.activity.toolsui

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityOpenBounceBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.function_open_bounce_activity)
class OpenBounceActivity : BaseActivity() {

    private lateinit var binding: ActivityOpenBounceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenBounceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}