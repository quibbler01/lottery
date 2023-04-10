package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityColorfulBeanBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.BeanStoreRecyclerListAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.self_activity_color_bean)
class ColorfulBeanActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityColorfulBeanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorfulBeanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        showRightTitleText(getString(R.string.redemption_records)) {
            ARouter.getInstance()
                .build(RouterCenter.self_activity_color_bean_redemption_records)
                .withString(RouterCenter.argument_title, getString(R.string.redemption_records))
                .navigation()
        }

        initView()
    }

    private fun initView() {
        binding.recyclerView.adapter = BeanStoreRecyclerListAdapter()
        binding.marqueTipsText.isSelected = true

        binding.questionIconAboutCurrentBean.setOnClickListener(this)
        binding.beanDetailButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.questionIconAboutCurrentBean.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.settings_activity_about_user_agreement)
                    .withString(RouterCenter.argument_title, getString(R.string.colorful_bean_explain))
                    .withString(RouterCenter.argument_file_name, PrivacyCommonViewActivity.colorfulBeanExplain)
                    .navigation()
            }
            binding.beanDetailButton.id -> {
                ARouter.getInstance()
                    .build(RouterCenter.self_activity_color_bean_detail)
                    .withString(RouterCenter.argument_title, getString(R.string.colorful_bean_detail))
                    .navigation()
            }
        }
    }

}