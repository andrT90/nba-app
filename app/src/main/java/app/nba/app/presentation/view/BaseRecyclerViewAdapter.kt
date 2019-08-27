package app.nba.app.presentation.view

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BaseRecyclerViewAdapter(
    vararg delegates: AdapterDelegate<List<BaseViewModel>>
) :
    AsyncListDifferDelegationAdapter<BaseViewModel>(BaseViewModelDiffCallback()) {

    init {
        for (delegate in delegates) {
            delegatesManager.addDelegate(delegate)
        }
    }

    private class BaseViewModelDiffCallback : DiffUtil.ItemCallback<BaseViewModel>() {
        override fun areItemsTheSame(oldItem: BaseViewModel, newItem: BaseViewModel): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: BaseViewModel, newItem: BaseViewModel): Boolean =
            oldItem.calculateDiff(newItem)

    }
}