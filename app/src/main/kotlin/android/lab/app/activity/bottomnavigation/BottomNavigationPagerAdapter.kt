package android.lab.app.activity.bottomnavigation

import android.lab.app.R
import android.lab.app.kotlin.Arguments
import android.lab.app.kotlin.withValues
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BottomNavigationPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val fragmentList: ArrayList<Fragment>

    init {
        fragmentList = ArrayList(5)
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(0, "Page1", R.color.yellow_500))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(1, "Page2", R.color.red_500))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(2, "Page3", R.color.blue_500))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(3, "Page4", R.color.grey_500))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(4, "Page5", R.color.indigo_500))
        })
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size
}