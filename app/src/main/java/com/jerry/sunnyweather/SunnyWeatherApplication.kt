package com.jerry.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/*
获取全局Context
*/
class SunnyWeatherApplication :Application(){
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN="rSl7JCIT7L7hTiwb"
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}