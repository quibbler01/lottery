package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityChargeDetailedBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.self_activity_charge_detail)
class ChargeDetailedActivity : BaseActivity() {

    private lateinit var binding: ActivityChargeDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChargeDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 1f

        showTitleRightIcon(AppCompatResources.getDrawable(this, R.drawable.question_icon)) {
            ARouter.getInstance()
                .build(RouterCenter.feed_back_page)
                .withString(RouterCenter.argument_title, getString(R.string.my_complaint))
                .navigation()
        }
    }


}