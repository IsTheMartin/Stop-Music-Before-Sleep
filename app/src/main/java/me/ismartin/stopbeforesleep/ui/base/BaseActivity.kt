package me.ismartin.stopbeforesleep.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.ismartin.stopbeforesleep.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}