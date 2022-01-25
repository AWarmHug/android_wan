package com.bingo.android_wan

import android.os.Bundle
import io.flutter.embedding.android.FlutterFragment
import io.flutter.plugin.common.MethodChannel

class FlutterAppFragment : FlutterFragment() {
    private val METHOD_CHANNEL = "com.bingo/method_channel"

    private var sMethodChannel: MethodChannel? = null

    private var callMap = mutableMapOf<Int, MethodChannel.Result>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sMethodChannel = MethodChannel(
            flutterEngine?.dartExecutor,
            METHOD_CHANNEL
        )
        sMethodChannel!!.setMethodCallHandler { call, result ->
            AppChannels.channels[call.method]?.onMethodCall(this, call, result)
        }
    }


    override fun onFlutterUiDisplayed() {
        super.onFlutterUiDisplayed()
        sMethodChannel!!.invokeMethod("setInitRoute", initialRoute)

    }

}