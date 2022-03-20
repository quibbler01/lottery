package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityPravicyCommonViewBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.settings_activity_about_user_agreement)
class PrivacyCommonViewActivity : BaseActivity() {

    private lateinit var binding:ActivityPravicyCommonViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPravicyCommonViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}