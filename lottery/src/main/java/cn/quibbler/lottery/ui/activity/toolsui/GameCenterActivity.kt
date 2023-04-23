package cn.quibbler.lottery.ui.activity.toolsui

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityGameCenterBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.function_game_center_activity)
class GameCenterActivity : BaseActivity() {

    private lateinit var binding: ActivityGameCenterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}