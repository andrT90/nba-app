package app.nba.app.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.nba.app.R
import app.nba.app.data.core.MessageDelegate
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), ErrorView, MessageView, LoadingView {

    @get:LayoutRes
    abstract val layoutRes: Int

    private var refresher: SwipeRefreshLayout? = null
    private var messageDelegate: MessageDelegate? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refresher = view.findViewById(R.id.refresher)
        messageDelegate = MessageDelegate(requireContext())
    }

    override fun onDestroyView() {
        messageDelegate = null
        super.onDestroyView()
    }

    override fun showLoading(show: Boolean) {
        refresher?.isRefreshing = show
    }

    override fun showMessage(message: CharSequence) {
        messageDelegate?.showMessage(message)
    }

    override fun showError(message: CharSequence) {
        messageDelegate?.showError(message)
    }
}