package android.lab.app.activity.number

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class NumberActivity : AppCompatActivity() {
    lateinit var ui: NumberView
    lateinit var numberText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = NumberView()
        ui.setContentView(this)

        supportActionBar?.let { bar ->
            bar.setDisplayHomeAsUpEnabled(true)
            bar.setHomeButtonEnabled(true)
        }

        numberText = find(ui.NUMBER_TEXT_ID)
        startAnimation()
    }

    fun startAnimation() {
        val anim = ValueAnimator.ofInt(100, 12)
        anim.duration = 1 * 1200
        anim.addUpdateListener {
            numberText.text = anim.animatedValue.toString()
        }
        anim.start()
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