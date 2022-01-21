package com.bingo.android_wan

import io.flutter.embedding.android.FlutterFragment
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

interface AppChannel {

    val name: String

    fun onMethodCall(fragment: FlutterFragment, call: MethodCall, result: MethodChannel.Result)

}

class AppChannels {

    companion object {

        val channels = mutableMapOf(
            getPair(DemoChannel()),
        )

        private fun getPair(channel: AppChannel): Pair<String, AppChannel> {
            return Pair(channel.name, channel)
        }

    }
}