package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipes(
    val count: Int,
    val recipes: List<Recipe>
) : Parcelable

@Parcelize
data class Recipe(
    val imageURL: String,
    val socialRank: Double,
    val id: String,
    val publisher: String,
    val publisherURL: String,
    val title: String
) : Parcelable

