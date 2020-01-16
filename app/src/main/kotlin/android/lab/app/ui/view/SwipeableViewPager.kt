package android.lab.app.ui.view

import android.content.Context
import android.lab.app.R
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class SwipeableViewPager : ViewPager {

    var swipeable: Boolean = true

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        with(context.theme.obtainStyledAttributes(attrs, R.styleable.ViewpagerSwipe, 0, 0)) {
            try {
                swipeable = this.getBoolean(R.styleable.ViewpagerSwipe_swipeable, true)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                this.recycle()
            }
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return swipeable && super.onInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return swipeable && super.onTouchEvent(event)
    }
}