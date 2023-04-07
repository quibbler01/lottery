package cn.quibbler.lottery.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityMessageCommentBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.message_activity_comment)
class MessageCommentActivity : BaseActivity() {

    private lateinit var binding: ActivityMessageCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}