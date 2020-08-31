package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.details.RecipeDetailsRepository
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.RecipeDetailsContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.RecipeDetailsState

class RecipeDetailsViewModel(private val repository: RecipeDetailsRepository) : ViewModel(),
    RecipeDetailsContract.ViewModel {

    override val recipeDetailsState: MutableLiveData<RecipeDetailsState> = MutableLiveData()

    override fun getById(id: String) {
        when (val res = repository.getDetails(id)) {
            is Resource.Success -> recipeDetailsState.value = RecipeDetailsState.Success(res.data)
        }
    }
}