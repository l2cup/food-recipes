package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val name: String,
    val imageURL: String
) : Parcelable