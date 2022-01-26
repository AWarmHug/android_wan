package com.bingo.android_wan.channels

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.bingo.android_wan.AppChannel
import com.bingo.android_wan.SecondActivity
import com.bingo.router.Router
import io.flutter.embedding.android.FlutterFragment
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

private const val TAG = "RouteChannel"

class RouteChannel : AppChannel {


    override val name: String
        get() = "route"

    override fun onMethodCall(
        fragment: FlutterFragment,
        call: MethodCall,
        result: MethodChannel.Result
    ) {

        Log.d(TAG, "onMethodCall: $call")

        val route = call.argument<String>("route")

        Router.newRequest(route).startBy(fragment)
    }

    override fun onMethodCall(activity: Activity, call: MethodCall, result: MethodChannel.Result) {
        Log.d(TAG, "onMethodCall: $call")

        val route = call.argument<String>("route")

        Router.newRequest(route).startBy(activity)
    }


}