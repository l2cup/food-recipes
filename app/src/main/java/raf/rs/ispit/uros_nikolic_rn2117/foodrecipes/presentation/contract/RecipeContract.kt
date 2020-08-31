package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract

import androidx.lifecycle.LiveData
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.RecipeState

interface RecipeContract {

    interface ViewModel {

        val recipeState: LiveData<RecipeState>
        var page: Int
        var lastQuery: String

        fun getAll()
        fun fetchPage(search: String, page: Int)
        fun getSaved(saved: Boolean = true)
        fun insert(recipe: Recipe)
        fun delete(id: String)
        fun filter(filter: String)

    }
}