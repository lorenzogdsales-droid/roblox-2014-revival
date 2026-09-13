package com.gameos.desktop
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityMainBinding
import com.gameos.desktop.ui.ModeSelectionActivity
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener {
            startActivity(Intent(this, ModeSelectionActivity::class.java))
        }
    }
}