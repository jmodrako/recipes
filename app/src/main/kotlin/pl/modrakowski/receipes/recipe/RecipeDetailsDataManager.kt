package pl.modrakowski.receipes.recipe

import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.select
import com.raizlabs.android.dbflow.kotlinextensions.where
import pl.modrakowski.receipes.common.BaseDataManager
import pl.modrakowski.receipes.common.DataListener
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.common.data.Recipe_Table.id

class RecipeDetailsDataManager : BaseDataManager<Recipe>() {
    override fun loadData(params: Any?, listener: DataListener<Recipe>) {
        val idVal: Long = params as Long
        listener.onDataLoadedSuccessfully((
                select from Recipe::class where id.eq(idVal)
                ).querySingle()!!)
    }
}