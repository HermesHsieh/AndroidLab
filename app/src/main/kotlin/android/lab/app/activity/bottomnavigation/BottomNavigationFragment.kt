package android.lab.app.activity.bottomnavigation

import android.content.Context
import android.lab.app.R
import android.lab.app.kotlin.Arguments
import android.lab.app.kotlin.getValue
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*
import org.jetbrains.anko.backgroundColor

class BottomNavigationFragment : Fragment() {

    val TAG = this.javaClass.simpleName

    private val args by getValue(Arguments.ARGS_BUNDLE_DATA, BottomNavigationArgs())

    private var checked = false

    override fun onAttach(context: Context) {
        println("$TAG onAttach[${args._id}] -----*")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("$TAG onCreate[${args._id}] -----*")
        super.onCreate(savedInstanceState)
        println("$TAG checked value[${args._id}]: $checked")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        println("$TAG onCreateView[${args._id}] -----*")
        val view = inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("$TAG onViewCreated[${args._id}] -----*")
        super.onViewCreated(view, savedInstanceState)
        println("onViewCreated: $view, title: ${args.title}")
        textView.text = args.title
        activity?.let {
            fragment_layout.backgroundColor = ContextCompat.getColor(it, args.bgColorRes)
        }
        println("$TAG checked value[${args._id}]: $checked")
        switch_compat?.isChecked = checked
        switch_compat?.setOnCheckedChangeListener { buttonView, isChecked ->
            println("$TAG setOnCheckedChangeListener isChecked[${args._id}]: $isChecked")
            checked = isChecked
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("$TAG onActivityCreated[${args._id}] -----*")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        println("$TAG onStart[${args._id}] -----*")
        super.onStart()
    }

    override fun onResume() {
        println("$TAG onResume[${args._id}] -----*")
        super.onResume()
    }

    override fun onPause() {
        println("$TAG onPause[${args._id}] -----*")
        super.onPause()
    }

    override fun onStop() {
        println("$TAG onStop[${args._id}] -----*")
        super.onStop()
    }

    override fun onDestroyView() {
        println("$TAG onDestroyView[${args._id}] -----*")
        super.onDestroyView()
    }

    override fun onDestroy() {
        println("$TAG onDestroy[${args._id}] -----*")
        super.onDestroy()
    }

    override fun onDetach() {
        println("$TAG onDetach[${args._id}] -----*")
        super.onDetach()
    }
}