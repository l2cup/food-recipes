package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_recipes")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long = 0,
    @ColumnInfo(name = "image_url") val imageURL: String,
    @ColumnInfo(name = "social_rank") val socialRank: Double,
    val id: String,
    val publisher: String,
    val title: String,
    @ColumnInfo(name = "source_url") val sourceURL: String,
    val saved: Boolean
)
