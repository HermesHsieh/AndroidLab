package android.lab.app.kotlin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import kotlin.properties.ReadWriteProperty

object DelegatesExt {
    fun <T> getPreference(categoryName: String, name: String, default: T, context: Context): ReadWriteProperty<Any?, T> =
            Preferences(categoryName, name, default, context)
}

inline fun <T : Fragment> T.withValues(argsBuilder: Bundle.() -> Unit):
        T = this.apply { arguments = Bundle().apply(argsBuilder) }

/**
 * Retrieve property with default value from intent
 */
fun <T : Any> FragmentActivity.getValue(key: String, default: T) = lazy {
    return@lazy if (intent == null || intent.extras == null) {
        default
    } else {
        intent.extras[key] as? T ?: default
    }
}

/**
 * Retrieve property with default value from intent
 */
fun <T : Any> Fragment.getValue(key: String, default: T) = lazy {
    arguments?.get(key)  as? T ?: default
}