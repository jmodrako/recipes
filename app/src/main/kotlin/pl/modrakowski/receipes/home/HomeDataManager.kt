package pl.modrakowski.receipes.home

import pl.modrakowski.receipes.common.BaseDataManager
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.home.data.HomeData

class HomeDataManager : BaseDataManager<HomeData>() {
    override fun loadData(listener: DataListener<HomeData>) {
        Thread {
            // Network delay.
            Thread.sleep(500)
            listener.onDataLoadedSuccessfully(prepareData())
        }.start()
    }

    private fun prepareData(): HomeData {
        return HomeData(listOf(
                Recipe("Schabowy", "http://karczmazabidwor.pl/files/page/zdjecia/potrawy/kotlet-%20schabowy.jpg"),
                Recipe("Gulasz", "http://r-scale-31.dcs.redcdn.pl/scale/o2/tvn/web-content/m/p96/i/81e5f81db77c596492e6f1a5a792ed53/09ba6a44-4447-11e2-bdd9-0025b511226e.jpg?type=1&srcmode=3&srcx=1%2F2&srcy=0%2F1&srcw=640&srch=360&dstw=640&dsth=360&quality=85"),
                Recipe("Schabowy", "http://karczmazabidwor.pl/files/page/zdjecia/potrawy/kotlet-%20schabowy.jpg"),
                Recipe("Kaszanka", "http://masarniakrzys.pl/files/masarnia_design/img/kaszanki/download/Kaszanka_Krzys.jpg"),
                Recipe("Gulasz", "http://r-scale-31.dcs.redcdn.pl/scale/o2/tvn/web-content/m/p96/i/81e5f81db77c596492e6f1a5a792ed53/09ba6a44-4447-11e2-bdd9-0025b511226e.jpg?type=1&srcmode=3&srcx=1%2F2&srcy=0%2F1&srcw=640&srch=360&dstw=640&dsth=360&quality=85"),
                Recipe("Kaszanka", "http://masarniakrzys.pl/files/masarnia_design/img/kaszanki/download/Kaszanka_Krzys.jpg")))
    }
}