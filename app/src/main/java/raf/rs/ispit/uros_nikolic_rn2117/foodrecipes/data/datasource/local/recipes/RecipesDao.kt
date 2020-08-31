package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.recipes

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room.RecipeEntity

@Dao
abstract class RecipesDao {

    @Query("SELECT * FROM food_recipes")
    abstract fun getAll(): Observable<List<RecipeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entity: RecipeEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(entities: List<RecipeEntity>)

    @Query("DELETE FROM food_recipes WHERE id=:id")
    abstract fun delete(id: String): Completable

    @Query("DELETE FROM food_recipes")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsert(entities: List<RecipeEntity>) {
        deleteAll()
        insertAll(entities)
    }

}