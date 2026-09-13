package com.gameos.desktop.ui
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gameos.desktop.databinding.ActivityTestModeBinding
import com.gameos.desktop.core.VirtualMachineEmulator
class TestModeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestModeBinding
    private lateinit var vmEmulator: VirtualMachineEmulator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vmEmulator = VirtualMachineEmulator(this)
        binding.tvTitle.text = "GameOS - Modo Teste"
        binding.tvDescription.text = "Ambiente Virtual Isolado - Seu sistema não será afetado"
        binding.btnLinuxVM.setOnClickListener { Toast.makeText(this, "Iniciando VM Linux...", Toast.LENGTH_SHORT).show(); vmEmulator.bootLinuxVM() }
        binding.btnWindowsVM.setOnClickListener { Toast.makeText(this, "Iniciando VM Windows...", Toast.LENGTH_SHORT).show(); vmEmulator.bootWindowsVM() }
        binding.btnAndroidVM.setOnClickListener { Toast.makeText(this, "Iniciando VM Android...", Toast.LENGTH_SHORT).show(); vmEmulator.bootAndroidVM() }
        binding.btnSaveProgress.setOnClickListener { vmEmulator.saveVMState(); Toast.makeText(this, "Progresso salvo", Toast.LENGTH_SHORT).show() }
        binding.btnLoadProgress.setOnClickListener { vmEmulator.loadVMState(); Toast.makeText(this, "Progresso carregado", Toast.LENGTH_SHORT).show() }
    }
}