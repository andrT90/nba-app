package app.nba.app.presentation.view

interface DiffViewModel<T> {

    fun calculateDiff(item: T): Boolean
}