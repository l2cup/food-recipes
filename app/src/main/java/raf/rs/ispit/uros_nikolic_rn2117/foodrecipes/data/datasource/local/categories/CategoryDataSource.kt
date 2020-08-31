package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.categories

import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category

interface CategoryDataSource {

    fun getCategories(): Observable<List<Category>>
}