package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.categories

import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category

interface CategoryRepository {
    fun getAll(): Observable<Resource<List<Category>>>
}