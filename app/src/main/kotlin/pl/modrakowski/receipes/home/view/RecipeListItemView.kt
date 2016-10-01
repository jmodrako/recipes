package pl.modrakowski.receipes.home.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.list_item_recipe.view.*
import pl.modrakowski.receipes.R
import pl.modrakowski.receipes.common.applyDefaultForeground
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.common.loadImage

class RecipeListItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item_recipe, this, true)
        applyDefaultForeground(this)
    }

    fun withModel(recipe: Recipe) {
        list_item_recipe_title.text = recipe.name;
        list_item_recipe_image.loadImage(recipe.imageUrl)
    }
}
