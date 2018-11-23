package com.hust.ping.googleio

import android.app.Application
import android.content.Context

/**
 * @created by PingYuan at 11/23/18
 * @email: husteryp@gmail.com
 * @description:
 */
class Application : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}