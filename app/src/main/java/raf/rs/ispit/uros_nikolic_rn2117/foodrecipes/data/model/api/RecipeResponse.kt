package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipesResponse(
    @Json(name = "count") val count: Int,
    @Json(name = "recipes") val recipes: List<RecipeResponse>
)

@JsonClass(generateAdapter = true)
data class RecipeResponse(
    @Json(name = "image_url") val imageURL: String,
    @Json(name = "social_rank") val socialRank: Double,
    @Json(name = "recipe_id") val id: String,
    @Json(name = "publisher") val publisher: String,
    @Json(name = "publisher_url") val publisherURL: String,
    @Json(name = "source_url") val sourceURL: String,
    @Json(name = "title") val title: String
)
