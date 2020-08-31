package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.remote

import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.api.RecipeDetailsResponse
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.api.RecipeDetailsResponseRoot
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.api.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("api/search")
    fun getByCategory(
        @Query("q") q: String,
        @Query("page") page: Int
    ): Observable<RecipesResponse>

    @GET("api/get")
    fun getById(@Query("rId") id: String): Observable<RecipeDetailsResponseRoot>

}