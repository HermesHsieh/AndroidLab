package android.lab.app.activity.viewpager2

import android.lab.app.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_viewpager2.*

class ViewPager2Activity : AppCompatActivity() {

    val TAG = this.javaClass.simpleName

    var selectedViewPagerPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2)

        view_pager?.adapter = ViewPager2Adapter(this)
        view_pager?.isUserInputEnabled = false
        view_pager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                println("$TAG onPageSelected position: $position")
                val size = bottom_navigation_view.menu.size()
                if (position < size && selectedViewPagerPosition < size) {
                    bottom_navigation_view.menu.getItem(selectedViewPagerPosition).isChecked = false
                    bottom_navigation_view.menu.getItem(position).isChecked = true
                    selectedViewPagerPosition = position
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })

        val smoothScroll = false

        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_item_0 -> {
                    view_pager?.setCurrentItem(0, smoothScroll)
                }
                R.id.navigation_item_1 -> {
                    view_pager?.setCurrentItem(1, smoothScroll)
                }
                R.id.navigation_item_2 -> {
                    view_pager?.setCurrentItem(2, smoothScroll)
                }
                R.id.navigation_item_3 -> {
                    view_pager?.setCurrentItem(3, smoothScroll)
                }
                R.id.navigation_item_4 -> {
                    view_pager?.setCurrentItem(4, smoothScroll)
                }
                else -> {
                    view_pager?.setCurrentItem(0, smoothScroll)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}