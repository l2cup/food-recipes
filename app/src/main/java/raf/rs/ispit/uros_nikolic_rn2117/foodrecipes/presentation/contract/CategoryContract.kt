package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract

import androidx.lifecycle.LiveData
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.CategoryState

interface CategoryContract {

    interface ViewModel {

        val categoryState: LiveData<CategoryState>

        fun getCategories()
    }
}