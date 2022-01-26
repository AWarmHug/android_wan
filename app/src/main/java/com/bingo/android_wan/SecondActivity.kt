package com.bingo.android_wan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bingo.android_wan.multipleflutters.SingleFlutterActivity
import com.bingo.router.Router
import com.bingo.router.annotations.Route
import io.flutter.embedding.android.FlutterActivity

@Route("/second/home")
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.tv).setOnClickListener {
//            Router.newRequest("/flutter/home").putString("route", "/login/login")
//                .startBy(this)

//            FlutterAppActivity.start(this, "/login/login")

            val flutterIntent = Intent(this, SingleFlutterActivity::class.java)
            startActivity(flutterIntent)

        }
    }
}