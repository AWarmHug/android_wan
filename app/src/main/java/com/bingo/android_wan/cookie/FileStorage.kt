package com.bingo.android_wan.cookie

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Cookie
import okhttp3.Headers
import okhttp3.HttpUrl
import okio.buffer
import okio.sink
import okio.source
import java.io.File
import java.nio.charset.Charset


class FileStorage(val dir: File) : Storage {
    val curDir: File

    init {
        curDir = File(dir, "ie0_ps1")
    }

    val gson = Gson()

    override fun write(url: HttpUrl, cookies: List<Cookie>) {
//        val file = File(curDir, url.host)
//        val sink = file.sink().buffer()
//        val json = gson.toJson(cookies)
//        sink.writeString(json, Charset.forName("UTF-8"))
        //todo

    }

    override fun read(url: HttpUrl): List<Cookie> {
        val file = File(curDir, url.host)
        val source = file.source().buffer()
        val cookiesStr = source.readString(Charset.forName("UTF-8"))
        //{"/":{"JSESSIONID":"JSESSIONID=E5D66E76EC4647D936A0F532A61F1EC4; Path=/; Secure; HttpOnly;_crt=1643350839","loginUserName":"loginUserName=1526; Expires=Sun, 27 Feb 2022 06:24:26 GMT; Path=/;_crt=1643351067","token_pass":"token_pass=ed9e2d2cb0ed666ca644224e189fe38f; Expires=Sun, 27 Feb 2022 06:24:26 GMT; Path=/;_crt=1643351067"}}

        if (cookiesStr.isEmpty()){
            return emptyList()
        }

        val map:Map<String,Map<String,String>> = gson.fromJson(cookiesStr, object : TypeToken<Map<String,Map<String,String>>>() {}.type)


        val t=map["/"]!!

        val cookies= mutableListOf<Cookie>()


        t.map {
            val cookie=Cookie.parse(url,it.value)
            cookie?.let {
                cookies.add(cookie)
            }
        }
        return cookies;


    }
}