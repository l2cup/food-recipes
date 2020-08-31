package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeDetails(
    val id: String,
    val ingredients: List<String>,
    val imageURL: String,
    val title: String,
    val publisher: String,
    val social: Double
) : Parcelable
