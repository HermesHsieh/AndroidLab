package android.lab.app.activity.bottomnavigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BottomNavigationPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val fragmentList: ArrayList<Fragment>

    init {
        fragmentList = ArrayList(5)
        fragmentList.add(BottomNavigationFragment())
        fragmentList.add(Fragment())
        fragmentList.add(BottomNavigationFragment())
        fragmentList.add(Fragment())
        fragmentList.add(BottomNavigationFragment())
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size
}