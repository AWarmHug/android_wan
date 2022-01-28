package com.bingo.android_wan.cookie

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class PersistenceCookieJar(val storage: Storage,persistSession:Boolean=true,ignoreExpires:Boolean=false) : CookieJar {


    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return storage.read(url)
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        storage.write(url, cookies)
    }
}