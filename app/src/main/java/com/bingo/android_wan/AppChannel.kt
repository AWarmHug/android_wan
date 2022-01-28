package com.bingo.android_wan

import android.app.Activity
import com.bingo.android_wan.channels.SetLoginStatusChannel
import com.bingo.android_wan.channels.RouteChannel
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

interface AppChannel {

    val name: String
        get() = this.javaClass.simpleName


    fun onMethodCall(activity: Activity, call: MethodCall, result: MethodChannel.Result)


}

class AppChannels {

    companion object {

        val channels = mutableMapOf(
            getPair(RouteChannel()),
            getPair(SetLoginStatusChannel()),
        )

        private fun getPair(channel: AppChannel): Pair<String, AppChannel> {
            return Pair(channel.name, channel)
        }

    }
}