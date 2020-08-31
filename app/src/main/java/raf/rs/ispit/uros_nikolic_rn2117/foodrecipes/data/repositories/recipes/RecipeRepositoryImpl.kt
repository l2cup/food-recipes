package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.recipes

import io.reactivex.Completable
import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.recipes.RecipesDao
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.remote.RecipeService
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.room.RecipeEntity
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.RecipeDetails
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipes
import timber.log.Timber

class RecipeRepositoryImpl(
    private var localDataSource: RecipesDao,
    private var remoteDataSource: RecipeService
) : RecipeRepository {

    override fun fetchPage(search: String, page: Int): Observable<Resource<Int>> {
        return remoteDataSource
            .getByCategory(search, page)
            .doOnNext { recipeList ->
                val entities = recipeList.recipes.map {
                    RecipeEntity(
                        0,
                        it.imageURL,
                        it.socialRank,
                        it.id,
                        it.publisher,
                        it.title,
                        it.sourceURL,
                        false
                    )
                }
                if (page == 1) {
                    localDataSource.deleteAndInsert(entities)
                } else {
                    localDataSource.insertAll(entities)
                }

            }.map {
                if(it.count == 0) {
                    return@map Resource.Empty(it.count)
                }

                Resource.Success(it.count)
            }
    }

    override fun getSaved(saved: Boolean): Observable<List<Recipe>> {
        TODO("Not yet implemented")
    }

    override fun getAll(): Observable<Resource<Recipes>> {
        return localDataSource.getAll()
            .map { list ->
                val recipesList = list.map {
                    Recipe(
                        it.imageURL,
                        it.socialRank,
                        it.id,
                        it.publisher,
                        it.sourceURL,
                        it.title
                    )
                }
                Resource.Success(Recipes(recipesList.size, recipesList))
            }
    }

    override fun getById(id: String): Observable<Resource<RecipeDetails>> {
        TODO("Not yet implemented")
    }

    override fun insert(note: Recipe): Completable {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Completable {
        TODO("Not yet implemented")
    }

}