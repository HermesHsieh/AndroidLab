package android.lab.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class LocaleChangedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        println("LocaleChangedReceiver onReceive Thread: ${Thread.currentThread().name}")
        if (intent?.action == Intent.ACTION_LOCALE_CHANGED) {
            println("LocaleChangedReceiver onReceive Locale is changed")
        }
    }
}