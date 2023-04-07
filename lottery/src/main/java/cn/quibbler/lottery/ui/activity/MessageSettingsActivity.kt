package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityMessageSettingsBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_message_settings)
class MessageSettingsActivity : BaseActivity() {

    private lateinit var binding: ActivityMessageSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageSettingsBinding.inflate(layoutInflater)

        supportActionBar?.elevation = 0f

        setContentView(binding.root)
    }

}