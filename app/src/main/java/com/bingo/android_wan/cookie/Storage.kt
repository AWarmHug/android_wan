package com.bingo.android_wan.cookie

import okhttp3.Cookie
import okhttp3.HttpUrl

interface Storage {

    fun write(url: HttpUrl, cookies: List<Cookie>)

    fun read(url: HttpUrl): List<Cookie>


}