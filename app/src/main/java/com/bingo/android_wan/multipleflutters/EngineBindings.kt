package com.bingo.android_wan.multipleflutters

import com.bingo.android_wan.AppChannels
import com.bingo.android_wan.METHOD_CHANNEL
import com.bingo.android_wan.MyApp
import io.flutter.FlutterInjector
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel


class EngineBindings(
    val activity: FlutterActivity,
    library: String? = null,
    functionName: String
) {

    val engine: FlutterEngine
    var channel: MethodChannel

    init {
        val app = activity.applicationContext as MyApp

        val dartEntrypoint = if (library != null) DartExecutor.DartEntrypoint(
            FlutterInjector.instance().flutterLoader().findAppBundlePath(),
            library,
            functionName
        ) else DartExecutor.DartEntrypoint(
            FlutterInjector.instance().flutterLoader().findAppBundlePath(),
            functionName
        )
        engine = app.engineGroup.createAndRunEngine(activity, dartEntrypoint, activity.initialRoute)
        channel = MethodChannel(
            engine.dartExecutor.binaryMessenger,
            METHOD_CHANNEL
        )
    }


    fun attach() {
        channel.setMethodCallHandler { call, result ->
            AppChannels.channels[call.method]?.onMethodCall(activity, call, result)
        }

    }

    fun detach() {
        engine.destroy()
        channel.setMethodCallHandler(null)
    }


}