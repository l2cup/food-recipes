package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.recipes.RecipeDetailsDao
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.recipes.RecipesDao
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room.RecipeDetailsEntity
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room.RecipeEntity

@Database(
    entities = [RecipeEntity::class, RecipeDetailsEntity::class],
    version = 7,
    exportSchema = false
)
@TypeConverters()
abstract class Database : RoomDatabase() {

    abstract fun getRecipesDao(): RecipesDao
    abstract fun getRecipeDetailsDao() : RecipeDetailsDao
}