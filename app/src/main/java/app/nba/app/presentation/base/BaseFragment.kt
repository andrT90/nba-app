package app.nba.app.presentation.base

import androidx.annotation.LayoutRes
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment() {

    @get:LayoutRes
    abstract val layoutRes: Int
}