package com.example.doinmac2

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class MyApplication :Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "还没找到"
    }

    override fun onCreate(){
        super.onCreate()
        context=applicationContext
    }
}