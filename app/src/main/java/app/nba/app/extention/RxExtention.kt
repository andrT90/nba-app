package app.nba.app.extention

import app.nba.app.data.exception.ApiException
import app.nba.app.data.net.dto.ServiceResponse
import app.nba.app.presentation.base.LoadingView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

fun <T> Single<T>.loading(view: LoadingView): Single<T> =
    this
        .doOnSubscribe { view.showLoading(true) }
        .doAfterTerminate { view.showLoading(false) }

fun <T> Single<T>.observeOnMain(): Single<T> =
    this
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<ServiceResponse<T>>.serviceResponseToData(): Single<T> =
    this.compose { upstream ->
        upstream.flatMap {
            if (it.data != null) Single.just(it.data)
            else Single.error(ApiException())
        }
    }