package android.lab.app.activity.viewpager2

import android.lab.app.R
import android.lab.app.activity.bottomnavigation.BottomNavigationArgs
import android.lab.app.activity.bottomnavigation.BottomNavigationFragment
import android.lab.app.kotlin.Arguments
import android.lab.app.kotlin.withValues
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val ITEM_SIZE = 10

    override fun getItemCount(): Int = ITEM_SIZE

    override fun createFragment(position: Int): Fragment {
        return BottomNavigationFragment().withValues {
            putSerializable(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs(position, "Page$position", R.color.yellow_500))
        }
    }
}