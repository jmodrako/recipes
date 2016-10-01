package pl.modrakowski.receipes.home

import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.list
import com.raizlabs.android.dbflow.kotlinextensions.select
import pl.modrakowski.receipes.common.BaseDataManager
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.home.data.HomeData

class HomeDataManager : BaseDataManager<HomeData>() {
    override fun loadData(params: Any?, listener: DataListener<HomeData>) {
        Thread {
            // Network delay.
            Thread.sleep(500)
            listener.onDataLoadedSuccessfully(prepareData())
        }.start()
    }

    private fun prepareData(): HomeData {
        return HomeData((select from Recipe::class).list)
    }
}