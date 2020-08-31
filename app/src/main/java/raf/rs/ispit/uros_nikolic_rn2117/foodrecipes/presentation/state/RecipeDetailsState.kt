package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state

import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.RecipeDetails
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipes


sealed class RecipeDetailsState {
    object Loading : RecipeDetailsState()
    data class Success(var recipes: RecipeDetails) : RecipeDetailsState()
    data class Error(val err: String) : RecipeDetailsState()
    data class DataFetched(val count: Int, val Page: Int) : RecipeDetailsState()
}
