package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityPravicyCommonViewBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route
import android.webkit.WebViewClient
import com.alibaba.android.arouter.facade.annotation.Autowired

@Route(path = RouterCenter.settings_activity_about_user_agreement)
class PrivacyCommonViewActivity : BaseActivity() {

    companion object {
        const val privacy = "privacy.html"
        const val user_agreement = "user_agreement.html"
        const val community_principle = "community_principle.html"
        const val community_agreement = "community_agreement.html"
        const val third_share_list = "third_share_list.html"
        const val chargeAgreement = "charge_agreement.html"
        const val colorfulBeanExplain = "colorful_bean_explain.html"
    }

    private lateinit var binding: ActivityPravicyCommonViewBinding

    @Autowired(name = RouterCenter.argument_file_name)
    @JvmField
    public var fileName = privacy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPravicyCommonViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 1f

        initViews()
    }

    private fun initViews() {
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("file:///android_asset/$fileName");
    }


}