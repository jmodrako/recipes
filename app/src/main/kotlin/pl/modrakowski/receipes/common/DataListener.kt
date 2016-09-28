package pl.modrakowski.receipes.common

interface DataListener<in DataType> {
    abstract fun onDataLoadedSuccessfully(data: DataType)
    abstract fun onDataLoadedError(error: Exception)
}