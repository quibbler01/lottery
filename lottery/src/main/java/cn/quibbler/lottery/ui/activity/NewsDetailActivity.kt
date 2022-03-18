package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.webkit.WebViewClient
import cn.quibbler.lottery.databinding.ActivityNewsDetailBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.news_detail_activity)
class NewsDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityNewsDetailBinding

    @Autowired(name = RouterCenter.argument_news_url)
    @JvmField
    public var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initWebView()
    }

    private fun initWebView() {
        binding.webView.webViewClient = WebViewClient()

        val setting = binding.webView.settings
        setting.setSupportZoom(false)
        setting.displayZoomControls = false
        setting.loadsImagesAutomatically = true
        setting.javaScriptEnabled = true
        setting.javaScriptCanOpenWindowsAutomatically = false
        setting.defaultTextEncodingName = "utf-8"

        url?.let { binding.webView.loadUrl(it) }
    }

}