package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityEditPersonalInformationBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.edit_personal_profile_page)
class EditPersonalInformationActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityEditPersonalInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPersonalInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.nicknameLayout.setOnClickListener(this)
        binding.decorateCenterLayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.nicknameLayout.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.change_nickname_page)
                    .withString(RouterCenter.argument_title, getString(R.string.edit_nickname))
                    .navigation()
            }
            binding.decorateCenterLayout.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.decorate_center_page)
                    .withString(RouterCenter.argument_title, getString(R.string.personal_decorate_center))
                    .navigation()
            }
        }
    }

}