package pl.modrakowski.receipes.home

import pl.modrakowski.receipes.common.BaseDataManager
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.home.data.HomeData

class HomeDataManager : BaseDataManager<HomeData>() {
    override fun loadData(listener: DataListener<HomeData>) {
        Thread {
            Thread.sleep(3000)

            listener.onDataLoadedSuccessfully(HomeData("jacek"))
        }.start()
    }
}