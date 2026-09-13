package com.gameos.desktop.ui
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityClockSetupBinding
import com.gameos.desktop.utils.GameOSStorage
class ClockSetupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClockSetupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClockSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTitle.text = "Configurar Hora do Sistema"
        binding.tvSubtitle.text = "Selecione a hora que deseja para o GameOS"
        binding.btnConfirm.setOnClickListener {
            val hour = binding.timePicker.hour
            val minute = binding.timePicker.minute
            GameOSStorage.saveSystemTime(this, hour, minute)
            Toast.makeText(this, "Hora configurada: $hour:${String.format("%02d", minute)}", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, DesktopEnvironmentActivity::class.java))
            finish()
        }
    }
}