package com.gameos.desktop.ui
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityModeSelectionBinding
class ModeSelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModeSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModeSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnTestMode.setOnClickListener { startActivity(Intent(this, TestModeActivity::class.java)) }
        binding.btnRealMode.setOnClickListener { startActivity(Intent(this, ClockSetupActivity::class.java)) }
    }
}