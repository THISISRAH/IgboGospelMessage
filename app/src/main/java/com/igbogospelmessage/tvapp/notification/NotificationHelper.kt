package com.igbogospelmessage.tvapp.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.WorkManager
import com.igbogospelmessage.tvapp.MainActivity
import com.igbogospelmessage.tvapp.R
import com.igbogospelmessage.tvapp.worker.VideoCheckWorker

class NotificationHelper(private val context: Context) {
    
    companion object {
        const val CHANNEL_ID = "igbo_gospel_message_channel"
        const val NOTIFICATION_ID = 1001
    }
    
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    
    init {
        createNotificationChannel()
    }
    
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = context.getString(R.string.channel_description)
                enableLights(true)
                enableVibration(true)
            }
            notificationManager.createNotificationChannel(channel)
        }
    }
    
    fun showNewVideoNotification(videoTitle: String, videoDescription: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.app_banner)
            .setContentTitle(context.getString(R.string.new_video_notification_title))
            .setContentText(videoTitle)
            .setStyle(NotificationCompat.BigTextStyle().bigText(videoDescription))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        
        notificationManager.notify(NOTIFICATION_ID, notification)
    }
    
    fun scheduleVideoCheck() {
        // Schedule periodic work to check for new videos
        val videoCheckRequest = androidx.work.PeriodicWorkRequestBuilder<VideoCheckWorker>(
            java.time.Duration.ofDays(1) // Check daily
        ).build()
        
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "video_check_work",
            androidx.work.ExistingPeriodicWorkPolicy.KEEP,
            videoCheckRequest
        )
    }
    
    fun cancelVideoCheck() {
        WorkManager.getInstance(context).cancelUniqueWork("video_check_work")
    }
}