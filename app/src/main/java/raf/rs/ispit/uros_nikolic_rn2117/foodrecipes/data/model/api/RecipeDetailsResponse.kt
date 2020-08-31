package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeDetailsResponseRoot(
    @Json(name = "recipe") val recipeDetails: RecipeDetailsResponse
)

@JsonClass(generateAdapter = true)
data class RecipeDetailsResponse(
    @Json(name = "ingredients") val ingredients: List<String>,
    @Json(name = "recipe_id") val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "publisher") val publisher: String,
    @Json(name = "social_rank") val social: Double,
    @Json(name = "image_url") val imageURL: String

) {}
