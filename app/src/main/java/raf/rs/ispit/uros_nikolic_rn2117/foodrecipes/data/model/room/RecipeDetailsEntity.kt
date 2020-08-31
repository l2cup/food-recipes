package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_recipe_details")
data class RecipeDetailsEntity(
    @PrimaryKey(autoGenerate = true) val _id: Long,
    val id: String,
    val publisher: String,
    val title: String
    //val ingredients: List<String>
)

