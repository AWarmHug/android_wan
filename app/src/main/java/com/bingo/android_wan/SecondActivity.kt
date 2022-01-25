package com.bingo.android_wan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bingo.router.annotations.Route

@Route("/second/home")
class SecondActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}