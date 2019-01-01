package android.lab.app.activity.bottomnavigation

import java.io.Serializable

data class BottomNavigationArgs(
        val _id: Int = -1,
        val title: String = "",
        val bgColorRes: Int = -1
) : Serializable