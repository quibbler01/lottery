package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
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
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return true
            }
        }

        val setting = binding.webView.settings
        setting.setSupportZoom(false)
        setting.displayZoomControls = false
        setting.loadWithOverviewMode = true
        setting.loadsImagesAutomatically = true
        setting.domStorageEnabled = true
        setting.javaScriptEnabled = true
        setting.javaScriptCanOpenWindowsAutomatically = false
        setting.defaultTextEncodingName = "UTF-8"
        //cache
        setting.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        url?.let { binding.webView.loadUrl(it) }
    }

}