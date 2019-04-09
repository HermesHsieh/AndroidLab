package android.lab.app.activity.number

import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class NumberView : AnkoComponent<NumberActivity> {
    val NUMBER_TEXT_ID = 1
    override fun createView(ui: AnkoContext<NumberActivity>): View {
        return ui.apply {
            verticalLayout {
                textView {
                    id = NUMBER_TEXT_ID
                }
            }
        }.view
    }
}