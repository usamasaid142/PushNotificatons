package com.example.pushnotificatons

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.pushnotificatons.databinding.ActivityMainBinding


//// register the notification channel
//
// 1- channel id
//2- channel name
//3-Notification channel
//
////  Notification Construction
//1 - Notification manger
//2- notificationCompat.bulider                     يستخدم للتوافق مع جميع الموبابلات
//
//// Notification Navigation
//1 - Notification Magager
//2- Pending Intent   ->  1- create intent 2- create pending intent 3- pass intent to pending intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()

    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun initButton() {
        binding.btnNotify.setOnClickListener {

           // triggerNotification()

            (application as (App)).ttrigerNotifiction("notification ", "this is my notification")

        }
    }

//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun triggerNotification() {
//
//        val notificationmanger = getSystemService(NotificationManager::class.java)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            createChannel(notificationmanger)
//        }
//        val intent = Intent(this, MainActivity::class.java)
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
//        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
//        // خصائس النوتيفيكشن
//        val notificationBuilder =
//            NotificationCompat.Builder(this, getString(R.string.Notification_channel_Id))
//                .setSmallIcon(R.drawable.ic_notyfy)
//                .setLargeIcon(
//                    BitmapFactory.decodeResource(
//                        resources,
//                        R.drawable.ic_launcher_background
//                    )
//                )
//                .setContentTitle("Notification title")
//                .setContentText(" this my notification updated")
//                .setStyle(
//                    NotificationCompat.BigTextStyle().bigText(" this my notification updated")
//                )
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setContentIntent(pendingIntent)
//                .setChannelId(getString(R.string.Notification_channel_Id))
//                .setAutoCancel(true)
//        val notificationmangercompat = NotificationManagerCompat.from(this)
//        notificationmangercompat.notify(resources.getInteger(R.integer.notificationid), notificationBuilder.build())
//    }


//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun createChannel(notificationmanger: NotificationManager) { //   create notification channel
//        val channel = NotificationChannel(
//            getString(R.string.Notification_channel_Id),
//            getString(R.string.Notification_channel_Name), IMPORTANCE_LOW
//        )
//        channel.setShowBadge(true)
//        channel.description = getString(R.string.cancel_description)
//        notificationmanger.createNotificationChannel(channel)
//
//    }


}