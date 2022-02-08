package com.bingo.android_wan.todo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bingo.android_wan.R
import com.bingo.android_wan.databinding.ActivityTodoBinding
import com.bingo.android_wan.multipleflutters.SingleFlutterActivity
import com.bingo.android_wan.route.TodoRoute
import com.bingo.router.annotations.Route

@Route(pathClass = TodoRoute.Main::class)
class TodoActivity : AppCompatActivity() {
    val binding: ActivityTodoBinding by lazy {
        return@lazy DataBindingUtil.setContentView(this, R.layout.activity_todo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {

        }


    }

    fun add(view: View) {
        val intent = Intent(this, SingleFlutterActivity::class.java)
        intent.putExtra("functionName", "main")
        intent.putExtra("route", "/todo/list")
        startActivity(intent)

    }
}