package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.recipes

import io.reactivex.Completable
import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.RecipeDetails
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipes

interface RecipeRepository {

    fun fetchPage(search: String, page: Int): Observable<Resource<Int>>
    fun getSaved(saved: Boolean = true): Observable<List<Recipe>>
    fun getAll(): Observable<Resource<Recipes>>
    fun getById(id: String): Observable<Resource<RecipeDetails>>
    fun insert(note: Recipe): Completable
    fun delete(id: String): Completable
}