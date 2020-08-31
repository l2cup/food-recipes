package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.details

import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.remote.RecipeService
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.RecipeDetails

class RecipeDetailsRepositoryImpl(private val remoteDataSource: RecipeService) :
    RecipeDetailsRepository {


    override fun getDetails(id: String): Resource<RecipeDetails> {
        val res = remoteDataSource.getById(id).blockingFirst()
        return Resource.Success(
            RecipeDetails(
                id,
                res.recipeDetails.ingredients,
                res.recipeDetails.imageURL,
                res.recipeDetails.title,
                res.recipeDetails.publisher,
                res.recipeDetails.social
            )
        )
    }
}