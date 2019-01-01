package android.lab.app.activity.bottomnavigation

import android.lab.app.R
import android.lab.app.kotlin.Arguments
import android.lab.app.kotlin.getValue
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*

class BottomNavigationFragment : Fragment() {

    private val args by getValue(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView.text = args.title
    }
}