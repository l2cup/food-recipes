package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.categories.CategoryDataSource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.categories.HardcodedCategoryDataSource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.categories.CategoryRepository
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.categories.CategoryRepositoryImpl
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.CategoryViewModel

val categoryModule = module {

    viewModel { CategoryViewModel(repository = get()) }

    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }

    single<CategoryDataSource> {
        HardcodedCategoryDataSource()
    }

}