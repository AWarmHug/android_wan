package com.bingo.android_wan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bingo.android_wan.multipleflutters.SingleFlutterActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.tv).setOnClickListener {
            FlutterAppActivity.start(this)
        }

        findViewById<Button>(R.id.single).setOnClickListener {
            val intent =FlutterActivity.NewEngineIntentBuilder(
                SingleFlutterActivity::class.java
            ).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.opaque)
                .build(this)
            startActivity(intent)
        }
    }
}