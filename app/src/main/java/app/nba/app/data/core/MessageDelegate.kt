package app.nba.app.data.core

import android.content.Context
import app.nba.app.extention.showToast

class MessageDelegate(private val context: Context?) {

    fun showMessage(text: CharSequence) {
        context?.showToast(text)
    }

    fun showError(text: CharSequence) {
        context?.showToast(text)
    }
}