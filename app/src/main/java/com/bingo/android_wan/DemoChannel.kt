package com.bingo.android_wan

import android.app.Activity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class DemoChannel : AppChannel {

    override val name: String
        get() = "login"

    override fun onMethodCall(
        fragment: FlutterFragment,
        call: MethodCall,
        result: MethodChannel.Result
    ) {

    }


}