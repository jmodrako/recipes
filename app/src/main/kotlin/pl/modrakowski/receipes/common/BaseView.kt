package pl.modrakowski.receipes.common

interface BaseView<in T> {
    fun onDataAvailable(data: T)
    fun onDataError(error: Exception)
}