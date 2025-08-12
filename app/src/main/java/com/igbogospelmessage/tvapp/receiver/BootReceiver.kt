package com.igbogospelmessage.tvapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.igbogospelmessage.tvapp.notification.NotificationHelper

class BootReceiver : BroadcastReceiver() {
    
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            // Restart notification scheduling after device boot
            val notificationHelper = NotificationHelper(context)
            notificationHelper.scheduleVideoCheck()
        }
    }
}