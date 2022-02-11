package com.bingo.android_wan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bingo.android_wan.multipleflutters.SingleFlutterActivity
import com.bingo.android_wan.robust.PatchManipulateImp
import com.meituan.robust.Patch
import com.meituan.robust.PatchExecutor
import com.meituan.robust.RobustCallBack
import com.meituan.robust.patch.annotaion.Modify

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity------"


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

        findViewById<Button>(R.id.btLoadPatch).setOnClickListener {
            PatchExecutor(this, PatchManipulateImp(), object : RobustCallBack {
                override fun onPatchListFetched(
                    result: Boolean,
                    isNet: Boolean,
                    patches: MutableList<Patch>?
                ) {
                    Log.d(TAG, "onPatchListFetched: ")
                }

                override fun onPatchFetched(result: Boolean, isNet: Boolean, patch: Patch?) {
                    Log.d(TAG, "onPatchFetched: ")
                }

                override fun onPatchApplied(result: Boolean, patch: Patch?) {
                    Log.d(TAG, "onPatchApplied: ")
                    if (result) {
                        Toast.makeText(this@MainActivity, "补丁成功", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@MainActivity, "补丁失败", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun logNotify(log: String?, where: String?) {
                    Log.d(TAG, "logNotify: ")
                }

                override fun exceptionNotify(throwable: Throwable?, where: String?) {
                    Log.d(TAG, "exceptionNotify: ")
                }
            }).start()
        }

        findViewById<Button>(R.id.testPatch).setOnClickListener {
            testPatch()
        }

    }

    @Modify
    fun testPatch() {

        Toast.makeText(this, "修复好了，恭喜！", Toast.LENGTH_SHORT).show()
    }

}