package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityAboutUsBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.settings_activity_about)
class AboutUsActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.userAgreementLayout.setOnClickListener(this)
        binding.settingsPrivacyLayout.setOnClickListener(this)
        binding.settingsSocityLayout.setOnClickListener(this)
        binding.settingsSocityAgreementLayout.setOnClickListener(this)
        binding.settingsThirdShareListLayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.userAgreementLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_about_user_agreement)
                    .withString(RouterCenter.argument_title, getAppString(R.string.settings_user_agreement))
                    .withString(RouterCenter.argument_file_name, PrivacyCommonViewActivity.privacy)
                    .navigation()
            }
            binding.settingsPrivacyLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_about_user_agreement)
                    .withString(RouterCenter.argument_title, getAppString(R.string.settings_privacy))
                    .withString(RouterCenter.argument_file_name, PrivacyCommonViewActivity.user_agreement)
                    .navigation()
            }
            binding.settingsSocityLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_about_user_agreement)
                    .withString(RouterCenter.argument_title, getAppString(R.string.settings_socity))
                    .withString(RouterCenter.argument_file_name, PrivacyCommonViewActivity.community_principle)
                    .navigation()
            }
            binding.settingsSocityAgreementLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_about_user_agreement)
                    .withString(RouterCenter.argument_title, getAppString(R.string.settings_socity_agreement))
                    .withString(RouterCenter.argument_file_name, PrivacyCommonViewActivity.community_agreement)
                    .navigation()
            }
            binding.settingsThirdShareListLayout.id -> {
                ARouter.getInstance().build(RouterCenter.settings_activity_about_user_agreement)
                    .withString(RouterCenter.argument_title, getAppString(R.string.settings_third_share_list))
                    .withString(RouterCenter.argument_file_name, PrivacyCommonViewActivity.third_share_list)
                    .navigation()
            }
        }
    }

}