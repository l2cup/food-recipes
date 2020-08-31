package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.categories

import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.categories.CategoryDataSource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category


class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository {

    override fun getAll(): Observable<Resource<List<Category>>> {
        return dataSource.getCategories().map {
            Resource.Success(it)
        }
    }
}

