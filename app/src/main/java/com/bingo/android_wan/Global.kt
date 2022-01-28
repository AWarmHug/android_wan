package com.bingo.android_wan

import android.content.Context
import com.bingo.android_wan.cookie.FileStorage
import com.bingo.android_wan.cookie.PersistenceCookieJar
import io.flutter.plugins.pathprovider.PathProviderPlugin
import io.flutter.util.PathUtils
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File
import java.net.CookieManager

fun isLogin(context: Context): Boolean {

    val parentPath = PathUtils.getDataDirectory(context)
    val storage = FileStorage(File(parentPath))
    val cookieJar = PersistenceCookieJar(storage)
    val httpUrl = "https://www.wanandroid.com/".toHttpUrl()
    val cookies = cookieJar.loadForRequest(httpUrl)
    return cookies.firstOrNull { it.name == "token_pass" } != null

}