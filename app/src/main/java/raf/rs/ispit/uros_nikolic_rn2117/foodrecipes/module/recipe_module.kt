package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.Database
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.remote.RecipeService
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.recipes.RecipeRepository
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.recipes.RecipeRepositoryImpl
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.RecipeViewModel

val recipeModule = module {

    viewModel { RecipeViewModel(repository = get()) }

    single<RecipeRepository> {
        RecipeRepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }

    single { get<Database>().getRecipesDao() }
    single<RecipeService> { create(retrofit = get()) }

}