package com.bingo.android_wan.channels

import android.app.Activity
import android.util.Log
import com.bingo.android_wan.AppChannel
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class SetLoginStatusChannel : AppChannel {
    override val name: String
        get() = "SetLoginStatusChannel"

    override fun onMethodCall(activity: Activity, call: MethodCall, result: MethodChannel.Result) {

        val isLogin = call.argument<Boolean>("isLogin")

        Log.d("TAG", "onMethodCall: isLogin = $isLogin")

    }
}