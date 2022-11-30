package com.example.pushnotificatons

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi

class App:Application() {

    private lateinit var notificationApp:NotificationApp

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        notificationApp= NotificationApp(this).getInstance(this)
        notificationApp.createChannel(getString(R.string.Notification_channel_Id),getString(R.string.Notification_channel_Name))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun ttrigerNotifiction(title:String, contenttext:String){
        notificationApp.triggerNotification(getString(R.string.Notification_channel_Id),title,contenttext)
    }

}