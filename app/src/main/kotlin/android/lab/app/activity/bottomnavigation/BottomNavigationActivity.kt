package android.lab.app.activity.bottomnavigation

import android.lab.app.R
import android.lab.app.ui.viewpagertransformer.FadeInPageTransformer
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    lateinit var pagerAdapter: BottomNavigationPagerAdapter

    var selectedViewPagerPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        supportActionBar?.let { bar ->
            bar.setDisplayHomeAsUpEnabled(true)
            bar.setHomeButtonEnabled(true)
        }

        pagerAdapter = BottomNavigationPagerAdapter(supportFragmentManager)
        swipeable_view_pager.adapter = pagerAdapter

        swipeable_view_pager.setPageTransformer(true, FadeInPageTransformer())
//        swipeable_view_pager.setPageTransformer(true, FadePageTransformer())
//        swipeable_view_pager.setPageTransformer(true, DepthPageTransformer())
//        swipeable_view_pager.setPageTransformer(true, ZoomOutPageTransformer())

        // this setting will disable item icon tint colored
        // bottom_navigation_view.itemIconTintList = null

        val smoothScroll = false

        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_item_0 -> {
                    swipeable_view_pager.setCurrentItem(0, smoothScroll)
                }
                R.id.navigation_item_1 -> {
                    swipeable_view_pager.setCurrentItem(1, smoothScroll)
                }
                R.id.navigation_item_2 -> {
                    swipeable_view_pager.setCurrentItem(2, smoothScroll)
                }
                R.id.navigation_item_3 -> {
                    swipeable_view_pager.setCurrentItem(3, smoothScroll)
                }
                R.id.navigation_item_4 -> {
                    swipeable_view_pager.setCurrentItem(4, smoothScroll)
                }
                else -> {
                    swipeable_view_pager.setCurrentItem(0, smoothScroll)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

        swipeable_view_pager.clearOnPageChangeListeners()
        swipeable_view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                bottom_navigation_view.menu.getItem(selectedViewPagerPosition).isChecked = false
                bottom_navigation_view.menu.getItem(position).isChecked = true
                selectedViewPagerPosition = position
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}