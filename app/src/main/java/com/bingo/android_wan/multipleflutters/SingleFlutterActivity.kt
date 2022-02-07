package com.bingo.android_wan.multipleflutters

import android.content.Context
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class SingleFlutterActivity : FlutterActivity() {

    private val library: String? by lazy {
        return@lazy intent.getStringExtra("library")
    }

    private val functionName: String by lazy {
        return@lazy intent.getStringExtra("functionName") ?: "main"
    }

    private val engineBindings: EngineBindings by lazy {
        EngineBindings(this, library, functionName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        engineBindings.attach()
    }

    override fun getInitialRoute(): String? {
        return super.getInitialRoute()
    }

    override fun onDestroy() {
        super.onDestroy()
        engineBindings.detach()
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine {
        return engineBindings.engine
    }

}