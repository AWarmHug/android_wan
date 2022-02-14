package com.bingo.android_wan.leakcanary

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bingo.android_wan.R
import com.bingo.android_wan.databinding.ActivityLeakCanaryBinding
import leakcanary.AppWatcher

class LeakCanaryActivity : AppCompatActivity() {

    companion object {
        private val activity = this

        lateinit var view: View
    }

    private val binding: ActivityLeakCanaryBinding by lazy {
        return@lazy DataBindingUtil.setContentView(this, R.layout.activity_leak_canary)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            view = binding.root
        }

    }

    override fun onDestroy() {
        super.onDestroy()

    }


}