package cn.quibbler.lottery.ui.activity.toolsui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityVipMembershipBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.vip_membership_activity)
class VipMembershipActivity : BaseActivity() {

    private lateinit var binding: ActivityVipMembershipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVipMembershipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }
}