package me.ismartin.stopbeforesleep.utils

import android.bluetooth.BluetoothAdapter
import timber.log.Timber

/**
 * Created by martin.morales on 05/07/21
 */
class BluetoothComponent {

    fun hasBluetooth(): Boolean = BluetoothAdapter.getDefaultAdapter() == null

    private fun isBluetoothOn(bt: BluetoothAdapter) = bt.isEnabled

    fun turnOffBluetooth() {
        val bt = BluetoothAdapter.getDefaultAdapter()
        try {
            if (isBluetoothOn(bt))
                bt.disable()
        } catch (e: NullPointerException) {
            Timber.e(e)
        }
    }

}