package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityRealNameBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.settings_activity_pay_realname)
class RealNameActivity : BaseActivity() {

    private lateinit var binding: ActivityRealNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}