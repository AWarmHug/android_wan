package com.bingo.android_wan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bingo.android_wan.multipleflutters.SingleFlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.tv).setOnClickListener {
        }

        findViewById<Button>(R.id.wan).setOnClickListener {
            val intent = Intent(this, SingleFlutterActivity::class.java)
            intent.putExtra("functionName", "main")
            startActivity(intent)
        }

        findViewById<Button>(R.id.navigator1).setOnClickListener {
            val intent = Intent(this, SingleFlutterActivity::class.java)
            intent.putExtra("functionName", "mainNavigator1")
            intent.putExtra("route", "/page2")
            startActivity(intent)
        }

        findViewById<Button>(R.id.navigator2).setOnClickListener {
            val intent = Intent(this, SingleFlutterActivity::class.java)
            intent.putExtra("functionName", "mainNavigator2")
//            intent.putExtra("route", "/home")
            startActivity(intent)
        }

        findViewById<Button>(R.id.login).setOnClickListener {


            val intent = Intent(this, SingleFlutterActivity::class.java)
            intent.putExtra("functionName", "main")
            intent.putExtra("route", "/login/login")
            startActivity(intent)
        }

        findViewById<Button>(R.id.isLogin).setOnClickListener {
            Log.d("TAG", "onCreate: isLogin=${isLogin(this)}")
            Toast.makeText(this, if (isLogin(this)) "已登录" else "未登录", Toast.LENGTH_SHORT).show()


        }


    }
}