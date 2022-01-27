package com.bingo.android_wan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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

        findViewById<Button>(R.id.wan).setOnClickListener {
            val intent = Intent(this, SingleFlutterActivity::class.java)
            intent.putExtra("entrypoint", "main")
            startActivity(intent)
        }

        findViewById<Button>(R.id.navigator1).setOnClickListener {
            val intent = Intent(this, SingleFlutterActivity::class.java)
            intent.putExtra("entrypoint", "mainNavigator1")
            intent.putExtra("route", "/page2")
            startActivity(intent)
        }

        findViewById<Button>(R.id.navigator2).setOnClickListener {
            val intent = Intent(this, SingleFlutterActivity::class.java)
            intent.putExtra("entrypoint", "mainNavigator2")
//            intent.putExtra("route", "/home")
            startActivity(intent)
        }
    }
}