package pl.modrakowski.receipes.common.data

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.kotlinextensions.modelAdapter
import com.raizlabs.android.dbflow.structure.Model
import pl.modrakowski.receipes.data.AppDatabase

@Table(database = AppDatabase::class)
data class Recipe(
        @PrimaryKey(autoincrement = true) var id: Long = 0,
        @Column var name: String = "",
        @Column var imageUrl: String = "") : Model {

    override fun save() = modelAdapter<Recipe>().save(this)

    override fun delete() = modelAdapter<Recipe>().delete(this)

    override fun update() = modelAdapter<Recipe>().update(this)

    override fun insert() = modelAdapter<Recipe>().insert(this)

    override fun exists() = modelAdapter<Recipe>().exists(this)
}