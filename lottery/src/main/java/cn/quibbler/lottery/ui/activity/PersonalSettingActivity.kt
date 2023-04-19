package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityPersonalSettingBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.self_personal_setting_page)
class PersonalSettingActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPersonalSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.editPersonalInformationLayout.setOnClickListener(this)
        binding.blacklistLayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.editPersonalInformationLayout.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.edit_personal_profile_page)
                    .withString(RouterCenter.argument_title, getString(R.string.edit_personal_information))
                    .navigation()
            }
            binding.blacklistLayout.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.black_list_page)
                    .withString(RouterCenter.argument_title, getString(R.string.blacklist))
                    .navigation()
            }
        }
    }

}