package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.categories.CategoryDataSource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.categories.HardcodedCategoryDataSource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.details.RecipeDetailsRepository
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.details.RecipeDetailsRepositoryImpl
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.RecipeDetailsViewModel

val detailsModule = module {

    viewModel { RecipeDetailsViewModel(repository = get()) }

    single<RecipeDetailsRepository> {
        RecipeDetailsRepositoryImpl(get())
    }

}