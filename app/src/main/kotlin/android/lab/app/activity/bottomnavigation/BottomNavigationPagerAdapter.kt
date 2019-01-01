package android.lab.app.activity.bottomnavigation

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
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(0, "Page1"))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(1, "Page2"))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(2, "Page3"))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(3, "Page4"))
        })
        fragmentList.add(BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(4, "Page5"))
        })
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size
}