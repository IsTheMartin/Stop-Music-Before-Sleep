package me.ismartin.stopbeforesleep.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import me.ismartin.stopbeforesleep.R
import me.ismartin.stopbeforesleep.databinding.ActivityBaseBinding
import me.ismartin.stopbeforesleep.utils.BluetoothComponent
import timber.log.Timber

@AndroidEntryPoint
class BaseActivity : AppCompatActivity(R.layout.activity_base) {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        val btc = BluetoothComponent()
        if(!btc.hasBluetooth())
            binding.btnTurnOffBluetooth.isEnabled = false

        binding.btnTurnOffBluetooth.setOnClickListener {
            btc.turnOffBluetooth()
        }
    }
}