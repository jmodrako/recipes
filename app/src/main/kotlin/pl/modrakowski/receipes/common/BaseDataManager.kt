package pl.modrakowski.receipes.common

abstract class BaseDataManager<out T> {

    abstract fun loadData(params: Any? = null, listener: DataListener<T>)
}