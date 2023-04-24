package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityAboutSmartRecommendBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.about_smart_recommend_activity)
class AboutSmartRecommendActivity : BaseActivity() {

    private lateinit var binding: ActivityAboutSmartRecommendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutSmartRecommendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 1f
    }

}