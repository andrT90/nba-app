package app.nba.app.data.core

import android.content.Context
import androidx.annotation.StringRes

class ResourseManager(private val appContext: Context) {

    fun getString(@StringRes resId: Int): String = appContext.getString(resId)

    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String =
        appContext.getString(resId, *formatArgs)
}