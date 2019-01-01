package android.lab.app.ui.viewpagertransformer

import android.support.v4.view.ViewPager
import android.view.View

class FadePageTransformer : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val pageWidth = view.width

        /*
     * When a page's alpha is set to 0 it's visibility should also be set to gone.
     * Even though the view isn't visible it can still be interacted with if it isn't gone and is drawn on top.
     */

        /*
     * Position is checked right up next to -1 and 1. The reason is because sometimes the position doesn't seem to come
     * all the way through as a whole number. Meaning it seems it would stop so very close to -1 or 0 (for example) and
     * the code to make necessary views 'gone' never gets called. So then there could be an invisible view on top that is
     * still able to be interacted with.
     */

        if (position < -0.999f) { // [-Infinity,-1)
            // This page is way off-screen to the left so hide it.
            view.alpha = 0f
            view.visibility = View.GONE
            view.translationX = pageWidth.toFloat()
        } else if (position <= 0.999f) { // (-1, 1)
            // The further the page is from being center page the more transparent it is.
            view.alpha = getAlpha(position)
            // Counteract the default slide transition
            view.translationX = pageWidth * -position
            // Make sure the page is visible
            view.visibility = View.VISIBLE
        } else { // (1,+Infinity]
            // This page is way off-screen to the right so hide it.
            view.alpha = 0f
            view.visibility = View.GONE
            view.translationX = (-pageWidth).toFloat()
        }
    }

    /**
     * Get the alpha value that should be applied to a position.
     *
     * @param position Position to find an alpha for.
     * @return An alpha value.
     */
    private fun getAlpha(position: Float): Float {
        return getSlowQuadraticAlpha(position)
    }

    private fun getLinearAlpha(position: Float): Float {
        return if (position <= 0) {
            1 + position
        } else 1 - position
    }

    private fun getFastQuadraticAlpha(position: Float): Float {
        val linearAlpha = getLinearAlpha(position)
        return linearAlpha * linearAlpha
    }

    private fun getSlowQuadraticAlpha(position: Float): Float {
        return 1 - position * position
    }
}