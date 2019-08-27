package app.nba.app.data.navigation

import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import ru.terrakok.cicerone.android.support.SupportAppNavigator

open class AppNavigator(
    activity: FragmentActivity,
    @LayoutRes containerId: Int,
    fragmentManager: FragmentManager
) : SupportAppNavigator(activity, fragmentManager, containerId)