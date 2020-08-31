package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state

import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipes

sealed class RecipeState {
    object Loading : RecipeState()
    data class Success(var recipes: Recipes) : RecipeState()
    data class Error(val err: String) : RecipeState()
    data class DataFetched(val count: Int, val Page: Int) : RecipeState()
    object RecipeAddSuccess : RecipeState()
    object RecipeDeleteSuccess : RecipeState()
    object Empty: RecipeState()

}
