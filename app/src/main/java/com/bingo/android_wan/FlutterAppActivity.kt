package com.bingo.android_wan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bingo.router.annotations.Route
import io.flutter.Log
import io.flutter.embedding.android.*
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode
import io.flutter.embedding.engine.FlutterShellArgs

@Route("/flutter/home")
class FlutterAppActivity : FlutterFragmentActivity() {
    private val TAG = "FlutterAppActivity"
    val route: String? by lazy {
        return@lazy intent.getStringExtra("route")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    override fun getInitialRoute(): String? {
        return route ?: super.getInitialRoute()
    }

    override fun createFlutterFragment(): FlutterFragment {
        val backgroundMode = backgroundMode
        val renderMode = renderMode
        val transparencyMode =
            if (backgroundMode == BackgroundMode.opaque) TransparencyMode.opaque else TransparencyMode.transparent

        return if (cachedEngineId != null) {
            FlutterFragment.CachedEngineFragmentBuilder(
                FlutterAppFragment::class.java,
                cachedEngineId!!
            )
                .renderMode(renderMode)
                .transparencyMode(transparencyMode)
                .handleDeeplinking(shouldHandleDeeplinking())
                .shouldAttachEngineToActivity(shouldAttachEngineToActivity())
                .destroyEngineWithFragment(shouldDestroyEngineWithHost())
                .build()
        } else {
            FlutterFragment.NewEngineFragmentBuilder(FlutterAppFragment::class.java)
                .dartEntrypoint(dartEntrypointFunctionName)
                .initialRoute(initialRoute!!)
                .appBundlePath(appBundlePath)
                .flutterShellArgs(FlutterShellArgs.fromIntent(intent))
                .handleDeeplinking(shouldHandleDeeplinking())
                .renderMode(renderMode)
                .transparencyMode(transparencyMode)
                .shouldAttachEngineToActivity(shouldAttachEngineToActivity())
                .build()
        }

    }

    companion object {
        fun start(context: Context, route: String? = null) {
            val intent = CachedEngineIntentBuilder(
                FlutterAppActivity::class.java,
                "flutter_engine_0"
            ).build(
                context
            )
            intent.putExtra("route", route)
            context.startActivity(intent)
        }
    }


}