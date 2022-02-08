package com.bingo.android_wan.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bingo.android_wan.R
import com.bingo.android_wan.route.TodoRoute
import com.bingo.router.annotations.Route

@Route(pathClass = TodoRoute.Main::class)
class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)




    }
}