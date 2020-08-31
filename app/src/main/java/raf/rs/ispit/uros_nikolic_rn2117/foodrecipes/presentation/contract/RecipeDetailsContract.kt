package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract

import androidx.lifecycle.LiveData
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.RecipeDetailsState


interface RecipeDetailsContract {

    interface ViewModel {

        val recipeDetailsState: LiveData<RecipeDetailsState>

        fun getById(id: String)


    }
}