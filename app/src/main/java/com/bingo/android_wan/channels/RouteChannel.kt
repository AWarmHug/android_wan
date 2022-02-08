package com.bingo.android_wan.channels

import android.app.Activity
import android.util.Log
import com.bingo.android_wan.AppChannel
import com.bingo.router.Router
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

private const val TAG = "RouteChannel"

class RouteChannel : AppChannel {


    override val name: String
        get() = "route"


    override fun onMethodCall(activity: Activity, call: MethodCall, result: MethodChannel.Result) {
        Log.d(TAG, "onMethodCall: $call")

        val route = call.argument<String>("route")

        Router.newRequest(route).startBy(activity)
    }


}