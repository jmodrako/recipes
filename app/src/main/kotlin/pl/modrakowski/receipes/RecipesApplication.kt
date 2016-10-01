package pl.modrakowski.receipes

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import pl.modrakowski.receipes.common.data.Recipe

class RecipesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FlowManager.init(FlowConfig.Builder(this).build())

        initStaticData()
    }

    private fun initStaticData() {
        Recipe(1L, "Schabowy", "http://karczmazabidwor.pl/files/page/zdjecia/potrawy/kotlet-%20schabowy.jpg").insert()
        Recipe(2L, "Gulasz", "http://r-scale-31.dcs.redcdn.pl/scale/o2/tvn/web-content/m/p96/i/81e5f81db77c596492e6f1a5a792ed53/09ba6a44-4447-11e2-bdd9-0025b511226e.jpg?type=1&srcmode=3&srcx=1%2F2&srcy=0%2F1&srcw=640&srch=360&dstw=640&dsth=360&quality=85").insert()
        Recipe(3L, "Schabowy", "http://karczmazabidwor.pl/files/page/zdjecia/potrawy/kotlet-%20schabowy.jpg").insert()
        Recipe(4L, "Kaszanka", "http://masarniakrzys.pl/files/masarnia_design/img/kaszanki/download/Kaszanka_Krzys.jpg").insert()
        Recipe(5L, "Gulasz", "http://r-scale-31.dcs.redcdn.pl/scale/o2/tvn/web-content/m/p96/i/81e5f81db77c596492e6f1a5a792ed53/09ba6a44-4447-11e2-bdd9-0025b511226e.jpg?type=1&srcmode=3&srcx=1%2F2&srcy=0%2F1&srcw=640&srch=360&dstw=640&dsth=360&quality=85").insert()
        Recipe(6L, "Kaszanka", "http://masarniakrzys.pl/files/masarnia_design/img/kaszanki/download/Kaszanka_Krzys.jpg").insert()
    }
}