package pl.modrakowski.receipes.common

abstract class BaseDataManager<out T> {
    abstract fun loadData(listener: DataListener<T>)
}