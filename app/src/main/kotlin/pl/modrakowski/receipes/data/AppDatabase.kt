package pl.modrakowski.receipes.data

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
class AppDatabase {
    companion object {
        const val NAME: String = "RecipesDatabase"
        const val VERSION: Int = 1
    }
}