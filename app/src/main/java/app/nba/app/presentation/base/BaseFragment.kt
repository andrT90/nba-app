package app.nba.app.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.nba.app.R
import app.nba.app.data.core.MessageDelegate
import app.nba.app.extention.inflate
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), ErrorView, MessageView, LoadingView {

    @get:LayoutRes
    abstract val layoutRes: Int

    protected var refresher: SwipeRefreshLayout? = null
    private var messageDelegate: MessageDelegate? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = container?.inflate(layoutRes)
        refresher = v?.findViewById(R.id.refresher)
        messageDelegate = MessageDelegate(requireContext())
        return v
    }

    override fun onDestroyView() {
        refresher = null
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