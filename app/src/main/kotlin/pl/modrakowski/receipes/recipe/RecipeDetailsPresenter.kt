package pl.modrakowski.receipes.recipe

import pl.modrakowski.receipes.common.BasePresenter
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.common.data.Recipe

class RecipeDetailsPresenter : BasePresenter<RecipeDetailsView>() {
    val dataManager: RecipeDetailsDataManager = RecipeDetailsDataManager()

    fun loadRecipe(recipeId: Long) {
        dataManager.loadData(recipeId, object : DataListener<Recipe> {
            override fun onDataLoadedSuccessfully(data: Recipe) {
                view!!.onDataAvailable(data)
            }

            override fun onDataLoadedError(error: Exception) {
                view!!.onDataError(error)
            }
        })
    }
}