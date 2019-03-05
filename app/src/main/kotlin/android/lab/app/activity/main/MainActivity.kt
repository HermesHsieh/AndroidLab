package android.lab.app.activity.main

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.lab.app.R
import android.lab.app.activity.bottomnavigation.BottomNavigationActivity
import android.lab.app.receiver.LocaleChangedReceiver
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    var localeChangedReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_bottom_navigation.setOnClickListener {
            startActivity<BottomNavigationActivity>()
        }
        println("*---Default---*")
        printLocale(Locale.getDefault())
        println("*---CHINA---*")
        printLocale(Locale.CHINA)
        println("*---TAIWAN---*")
        printLocale(Locale.TAIWAN)
        println("*---US---*")
        printLocale(Locale.US)
        println("*---UK---*")
        printLocale(Locale.UK)
        println("*---CANADA---*")
        printLocale(Locale.CANADA)
        println("*---CHINESE---*")
        printLocale(Locale.CHINESE)
        println("*---ENGLISH---*")
        printLocale(Locale.ENGLISH)

        localeChangedReceiver = LocaleChangedReceiver()
        registerReceiver(localeChangedReceiver, IntentFilter(Intent.ACTION_LOCALE_CHANGED))
    }

    fun printLocale(locale: Locale) {
        with(locale) {
            print("Locale: $locale")
            println("displayName: " + this.displayName)
            println("displayLanguage: " + this.displayLanguage)
            println("displayCountry: " + this.displayCountry)
            println("displayScript: " + this.displayScript)
            println("displayVariant: " + this.displayVariant)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(localeChangedReceiver)
    }
}
