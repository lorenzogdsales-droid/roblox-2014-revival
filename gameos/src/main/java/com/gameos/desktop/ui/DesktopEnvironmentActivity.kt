package com.gameos.desktop.ui
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityDesktopEnvironmentBinding
import com.gameos.desktop.ui.games.EaglerraftActivity
import com.gameos.desktop.ui.games.RobloxLauncherActivity
import com.gameos.desktop.utils.GameOSStorage
import kotlin.concurrent.thread
class DesktopEnvironmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDesktopEnvironmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesktopEnvironmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val (hour, minute) = GameOSStorage.getSystemTime(this)
        updateClock(hour, minute)
        binding.btnEaglercraft.setOnClickListener { startActivity(Intent(this, EaglerraftActivity::class.java)) }
        binding.btnRoblox.setOnClickListener { startActivity(Intent(this, RobloxLauncherActivity::class.java)) }
        binding.btnWhatsapp.setOnClickListener { launchPlayStoreApp("com.whatsapp") }
        binding.btnAntivirus.setOnClickListener { launchPlayStoreApp("com.pandasecurity.pandadome") }
        startClockUpdate()
    }
    private fun startClockUpdate() {
        thread(daemon = true) { while (true) { val (hour, minute) = GameOSStorage.getSystemTime(this@DesktopEnvironmentActivity); runOnUiThread { updateClock(hour, minute) }; Thread.sleep(1000) } }
    }
    private fun updateClock(hour: Int, minute: Int) {
        val timeString = String.format("%02d:%02d", hour, minute)
        binding.tvClock.text = timeString
    }
    private fun launchPlayStoreApp(packageName: String) {
        try { startActivity(packageManager.getLaunchIntentForPackage(packageName) ?: Intent(Intent.ACTION_VIEW).apply { data = android.net.Uri.parse("https://play.google.com/store/apps/details?id=$packageName") }) } catch (e: Exception) {}
    }
}