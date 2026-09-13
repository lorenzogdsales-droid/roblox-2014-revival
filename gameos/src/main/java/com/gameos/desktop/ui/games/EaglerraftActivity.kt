package com.gameos.desktop.ui.games
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityEaglerraftBinding
class EaglerraftActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEaglerraftBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEaglerraftBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val webView = binding.webView
        webView.settings.apply { javaScriptEnabled = true; mediaPlaybackRequiresUserGesture = false; mixedContentMode = WebSettings.MIXED_CONTENT_ALLOW_ALL; databaseEnabled = true; domStorageEnabled = true; cacheMode = WebSettings.LOAD_DEFAULT }
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://eaglercraft.com/")
    }
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) binding.webView.goBack() else super.onBackPressed()
    }
}