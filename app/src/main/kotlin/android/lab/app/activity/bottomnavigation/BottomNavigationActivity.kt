package android.lab.app.activity.bottomnavigation

import android.lab.app.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    lateinit var pagerAdapter: BottomNavigationPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        pagerAdapter = BottomNavigationPagerAdapter(supportFragmentManager)
        swipeable_view_pager.adapter = pagerAdapter

        // this setting will disable item icon tint colored
        // bottom_navigation_view.itemIconTintList = null

        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_item_0 -> {
                    swipeable_view_pager.setCurrentItem(0, false)
                }
                R.id.navigation_item_1 -> {
                    swipeable_view_pager.setCurrentItem(1, false)
                }
                R.id.navigation_item_2 -> {
                    swipeable_view_pager.setCurrentItem(2, false)
                }
                R.id.navigation_item_3 -> {
                    swipeable_view_pager.setCurrentItem(3, false)
                }
                R.id.navigation_item_4 -> {
                    swipeable_view_pager.setCurrentItem(4, false)
                }
                else -> {
                    swipeable_view_pager.setCurrentItem(0, false)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}