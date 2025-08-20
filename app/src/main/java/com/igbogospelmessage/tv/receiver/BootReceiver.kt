package com.igbogospelmessage.tv.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.igbogospelmessage.tv.service.NotificationService

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            // Restart notification service after device reboot
            val serviceIntent = Intent(context, NotificationService::class.java)
            context.startService(serviceIntent)
        }
    }
}