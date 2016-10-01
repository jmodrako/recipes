package pl.modrakowski.receipes.home

import android.app.Activity
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import kotlinx.android.synthetic.main.list_item_recipe.view.*
import pl.modrakowski.receipes.R
import pl.modrakowski.receipes.common.BasePresenter
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.home.data.HomeData
import pl.modrakowski.receipes.home.view.RecipeListItemView
import pl.modrakowski.receipes.recipe.RecipeDetailsActivity

class HomePresenter : BasePresenter<HomeView>() {

    val dataManager: HomeDataManager = HomeDataManager()

    fun loadData(): Unit {
        dataManager.loadData(null, object : DataListener<HomeData> {
            override fun onDataLoadedSuccessfully(data: HomeData) {
                view?.onDataAvailable(data)
            }

            override fun onDataLoadedError(error: Exception) {
                view?.onDataError(error)
            }
        })
    }

    fun openRecipeDetails(activity: Activity, recipe: Recipe, recipeImage: RecipeListItemView) {
        val imagePair: android.support.v4.util.Pair<View, String> =
                android.support.v4.util.Pair(recipeImage.list_item_recipe_image,
                        activity.getString(R.string.shared_recipe_image))

//         Not working yet...
//        val titlePair: android.support.v4.util.Pair<View, String> =
//                android.support.v4.util.Pair(recipeImage.list_item_recipe_title,
//                        activity.getString(R.string.shared_recipe_title))

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, /*titlePair,*/ imagePair)
        activity.startActivity(RecipeDetailsActivity.intent(activity, recipe), options.toBundle())
    }
}