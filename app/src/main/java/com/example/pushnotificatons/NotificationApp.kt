package com.example.pushnotificatons

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationApp {

    private  var context: Context
    var instance: NotificationApp? = null
    private  var Notificationmangercompat: NotificationManagerCompat
    private  var notificationManager: NotificationManager

    constructor(context: Context) {
        this.context = context
        Notificationmangercompat = NotificationManagerCompat.from(context)
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    }

    private fun getInstance(context: Context):NotificationApp{
        if (instance==null){
            instance= NotificationApp(context)
        }
        return instance as NotificationApp
    }



    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(notification_id:String,notificatio_name:String) { //   create notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        val channel = NotificationChannel(
           notification_id,
           notificatio_name, NotificationManager.IMPORTANCE_LOW
        )
        channel.setShowBadge(true)
       // channel.description = getString(R.string.cancel_description)
        notificationManager.createNotificationChannel(channel)
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun triggerNotification(channel_id:String,title:String,conenttext:String) {


        val intent = Intent(context, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        // خصائس النوتيفيكشن
        val notificationBuilder =
            NotificationCompat.Builder(context,channel_id)
                .setSmallIcon(R.drawable.ic_notyfy)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                       context.resources,
                        R.drawable.ic_launcher_background
                    )
                )
                .setContentTitle(title)
                .setContentText(conenttext)
                .setStyle(
                    NotificationCompat.BigTextStyle().bigText(conenttext)
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channel_id)
                .setAutoCancel(true)

        Notificationmangercompat.notify(context.resources.getInteger(R.integer.notificationid), notificationBuilder.build())
    }
}