package com.bingo.android_wan

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import io.flutter.embedding.android.FlutterFragment
import io.flutter.plugin.common.MethodChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

    override fun getInitialRoute(): String? {
        if (activity is FlutterAppActivity) {
            return (activity as FlutterAppActivity).route
        }
        return super.getInitialRoute()
    }

    override fun onFlutterUiDisplayed() {
        super.onFlutterUiDisplayed()
        Log.d("TAG", "onFlutterUiDisplayed: ${initialRoute}")
        sMethodChannel!!.invokeMethod("setInitRoute", initialRoute)
    }

    override fun onFlutterUiNoLongerDisplayed() {
        super.onFlutterUiNoLongerDisplayed()
        Log.d("TAG", "onFlutterUiNoLongerDisplayed: ")

    }

}