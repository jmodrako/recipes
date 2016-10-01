package pl.modrakowski.receipes.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.home.view.RecipeListItemView

class HomeAdapter : RecyclerView.Adapter<HomeHolder>() {

    interface OnHomeItemClickListener {
        fun onHomeItemClick(recipe: Recipe, recipeImageView: RecipeListItemView)
    }

    val data: MutableList<Recipe> = mutableListOf()
    var onHomeItemClickListener: OnHomeItemClickListener? = null

    fun updateData(aData: List<Recipe>) {
        data.clear()
        data.addAll(aData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val view: RecipeListItemView = RecipeListItemView(parent.context)
        applyDefaultLayoutParams(view)
        return HomeHolder(view)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        val recipeView: RecipeListItemView = holder.recipeView

        val recipe: Recipe = data[position]
        recipeView.withModel(recipe)
        recipeView.setOnClickListener {
            onHomeItemClickListener?.onHomeItemClick(recipe, recipeView)
        }
    }

    override fun getItemCount(): Int = data.size

    private fun applyDefaultLayoutParams(result: View): View {
        result.layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT)
        return result;
    }
}

class HomeHolder(itemView: RecipeListItemView) : RecyclerView.ViewHolder(itemView) {
    val recipeView: RecipeListItemView = itemView
}