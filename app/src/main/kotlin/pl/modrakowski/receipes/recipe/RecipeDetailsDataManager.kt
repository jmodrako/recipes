package pl.modrakowski.receipes.recipe

import pl.modrakowski.receipes.common.BaseDataManager
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.common.data.Recipe

class RecipeDetailsDataManager : BaseDataManager<Recipe>() {
    override fun loadData(params: Any?, listener: DataListener<Recipe>) {
        listener.onDataLoadedSuccessfully(Recipe(1L, "Schabowy",
                "http://karczmazabidwor.pl/files/page/zdjecia/potrawy/kotlet-%20schabowy.jpg"))
    }
}