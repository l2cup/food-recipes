package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state

import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category


sealed class CategoryState {
    object Loading : CategoryState()
    data class Success(var categories: List<Category>) : CategoryState()
    data class Error(val err: String) : CategoryState()

}