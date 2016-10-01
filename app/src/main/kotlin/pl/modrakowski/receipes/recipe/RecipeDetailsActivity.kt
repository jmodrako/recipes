package pl.modrakowski.receipes.recipe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recipe_details.*
import pl.modrakowski.receipes.R
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.common.loadImage

class RecipeDetailsActivity : AppCompatActivity(), RecipeDetailsView {

    val presenter: RecipeDetailsPresenter = RecipeDetailsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
    }

    override fun onResume() {
        super.onResume()

        presenter.registerView(this)
        presenter.loadRecipe(extractRecipeId())
    }

    override fun onDataAvailable(data: Recipe) {
        recipe_details_title.text = data.name
        recipe_details_image.loadImage(data.imageUrl)
    }

    override fun onDataError(error: Exception) {
        // TODO
    }

    private fun extractRecipeId(): Long {
        return intent.getLongExtra(KEY_RECIPE_ID, UNKNOWN_RECIPE_ID)
    }

    companion object Builder {
        val KEY_RECIPE_ID: String = "key_recipe_id"
        val UNKNOWN_RECIPE_ID: Long = -1

        fun intent(activity: Activity, recipe: Recipe): Intent {
            val result: Intent = Intent(activity, RecipeDetailsActivity::class.java)
            result.putExtra(KEY_RECIPE_ID, recipe.id)
            return result
        }
    }
}