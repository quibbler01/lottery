package cn.quibbler.lottery.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityMessageFansBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.message_activity_fans)
class MessageFansActivity : BaseActivity() {

    private lateinit var binding: ActivityMessageFansBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageFansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}