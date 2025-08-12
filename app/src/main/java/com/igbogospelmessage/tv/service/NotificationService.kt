package com.igbogospelmessage.tv.service

import android.app.*
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.igbogospelmessage.tv.MainActivity
import com.igbogospelmessage.tv.R
import java.util.*

class NotificationService : Service() {
    
    companion object {
        private const val CHANNEL_ID = "igbo_gospel_channel"
        private const val NOTIFICATION_ID = 1
    }
    
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Schedule Friday notifications
        scheduleFridayNotifications()
        return START_STICKY
    }
    
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Igbo Gospel Message",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Notifications for new gospel messages"
        }
        
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
    
    private fun scheduleFridayNotifications() {
        // This would typically use WorkManager to schedule weekly notifications
        // For now, we'll create a simple notification
        showNewVideoNotification()
    }
    
    private fun showNewVideoNotification() {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_IMMUTABLE
        )
        
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("New Igbo Gospel Message Available!")
            .setContentText("A new video has been uploaded to our channel")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(NOTIFICATION_ID, notification)
    }
    
    override fun onBind(intent: Intent?): IBinder? = null
}