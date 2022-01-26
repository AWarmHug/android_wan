package com.bingo.android_wan.multipleflutters

import android.content.Context
import android.os.Bundle
import com.bingo.android_wan.AppChannels
import com.bingo.android_wan.METHOD_CHANNEL
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class SingleFlutterActivity : FlutterActivity() {

    val engineBindings: EngineBindings by lazy {
        EngineBindings(this, "main")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        engineBindings.attach()

    }

    override fun onDestroy() {
        super.onDestroy()
        engineBindings.detach()
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine {
        return engineBindings.engine
    }


}