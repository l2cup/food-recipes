package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.details

import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.api.RecipeDetailsResponse
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.RecipeDetails

interface RecipeDetailsRepository {

    fun getDetails(id: String): Resource<RecipeDetails>
}