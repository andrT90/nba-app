package app.nba.app.extention

import app.nba.app.presentation.base.LoadingView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

fun Single<*>.loading(view: LoadingView) =
    this
        .doOnSubscribe { view.showLoading(true) }
        .doAfterTerminate { view.showLoading(false) }

fun Single<*>.observeOnMain() =
    this
        .observeOn(AndroidSchedulers.mainThread())