package android.lab.app.ui.viewpagertransformer

import android.support.v4.view.ViewPager
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

class FadeInPageTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        println("transformPage: $view, position: $position")

//        val animSet = AnimationSet(true)
//        animSet.fillAfter = true

        val alpha = AlphaAnimation(0.6f, 1.0f)
        alpha.duration = 400

//        val scale = ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f)
//        scale.duration = 100

        alpha.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation) {
                println("AnimationListener onAnimationRepeat")
            }

            override fun onAnimationEnd(animation: Animation) {
                println("AnimationListener onAnimationEnd")
                view.alpha = 1f
            }

            override fun onAnimationStart(animation: Animation) {
                println("AnimationListener onAnimationStart")
                view.alpha = 1f
            }
        })

//        animSet.addAnimation(alpha)
//        animSet.addAnimation(scale)

//        animSet.repeatCount = 2
//        animSet.repeatMode = Animation.REVERSE

        view.startAnimation(alpha)
    }
}