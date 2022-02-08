package com.bingo.android_wan.route

import com.bingo.router.annotations.PathClass
import com.bingo.router.annotations.Route

interface TodoRoute {

    @PathClass("/todo/main")
    interface Main

}