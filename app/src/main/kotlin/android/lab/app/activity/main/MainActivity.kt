package android.lab.app.activity.main

import android.lab.app.R
import android.lab.app.activity.bottomnavigation.BottomNavigationActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_bottom_navigation.setOnClickListener {
            startActivity<BottomNavigationActivity>()
        }
    }
}
