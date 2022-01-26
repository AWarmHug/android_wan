package com.bingo.android_wan

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.FlutterEngineGroup
import io.flutter.embedding.engine.dart.DartExecutor

class MyApp : Application() {

    lateinit var engineGroup: FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        engineGroup = FlutterEngineGroup(this);

        val flutterEngine =
            engineGroup.createAndRunEngine(this, DartExecutor.DartEntrypoint.createDefault())


        FlutterEngineCache.getInstance().put("flutter_engine_0", flutterEngine)
    }
}