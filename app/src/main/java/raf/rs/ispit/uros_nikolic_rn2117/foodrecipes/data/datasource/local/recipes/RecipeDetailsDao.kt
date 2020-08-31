package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.recipes

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room.RecipeDetailsEntity
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room.RecipeEntity


@Dao
abstract class RecipeDetailsDao {

    @Query("SELECT * FROM food_recipe_details")
    abstract fun getAll(): Observable<List<RecipeDetailsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entity: RecipeEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(entities: List<RecipeDetailsEntity>)

    @Query("DELETE FROM food_recipe_details WHERE id=:id")
    abstract fun delete(id: String): Completable

    @Query("DELETE FROM food_recipes")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsert(entities: List<RecipeDetailsEntity>) {
        deleteAll()
        insertAll(entities)
    }

}