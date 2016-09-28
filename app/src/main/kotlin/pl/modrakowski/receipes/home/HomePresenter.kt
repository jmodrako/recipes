package pl.modrakowski.receipes.home

import pl.modrakowski.receipes.common.BasePresenter
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.home.data.HomeData

class HomePresenter : BasePresenter<HomeView>() {

    val dataManager: HomeDataManager = HomeDataManager()

    fun loadData(): Unit {
        dataManager.loadData(object : DataListener<HomeData> {
            override fun onDataLoadedSuccessfully(data: HomeData) {
                view?.onDataAvailable(data)
            }

            override fun onDataLoadedError(error: Exception) {
                view?.onDataError(error)
            }
        })
    }
}