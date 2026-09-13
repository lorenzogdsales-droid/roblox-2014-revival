package com.gameos.desktop.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityVirtualMachineBinding
class VirtualMachineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVirtualMachineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVirtualMachineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTitle.text = "Máquina Virtual"
        binding.tvStatus.text = "VM em execução..."
    }
}