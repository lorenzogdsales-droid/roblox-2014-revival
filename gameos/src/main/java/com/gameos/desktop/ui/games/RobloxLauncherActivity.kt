package com.gameos.desktop.ui.games
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityRobloxLauncherBinding
class RobloxLauncherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRobloxLauncherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRobloxLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTitle.text = "Roblox"
        binding.tvDescription.text = "Clique para abrir Roblox da Play Store"
        binding.btnLaunchRoblox.setOnClickListener { launchRoblox() }
    }
    private fun launchRoblox() {
        try { val intent = packageManager.getLaunchIntentForPackage("com.roblox.client"); if (intent != null) startActivity(intent) else openPlayStore("com.roblox.client") } catch (e: Exception) { openPlayStore("com.roblox.client") }
    }
    private fun openPlayStore(packageName: String) {
        val playStoreIntent = Intent(Intent.ACTION_VIEW).apply { data = android.net.Uri.parse("https://play.google.com/store/apps/details?id=$packageName") }
        startActivity(playStoreIntent)
    }
}