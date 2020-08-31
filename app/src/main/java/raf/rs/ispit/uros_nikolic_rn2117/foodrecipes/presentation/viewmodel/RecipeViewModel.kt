package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.recipes.RecipeRepository
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.RecipeContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.RecipeState

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel(),
    RecipeContract.ViewModel {


    override val recipeState: MutableLiveData<RecipeState> = MutableLiveData()
    private val publishSubject: PublishSubject<Int> = PublishSubject.create()
    private val subscriptions = CompositeDisposable()
    override var page: Int = 1
    override var lastQuery: String = ""



    override fun getAll() {
        val subscription = repository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when (it) {
                        is Resource.Success -> recipeState.value = RecipeState.Success(it.data)
                        is Resource.Error -> recipeState.value = RecipeState.Error(it.toString())
                    }
                },
                {
                    recipeState.value = RecipeState.Error(it.toString())
                }
            )
        subscriptions.add(subscription)
    }

    override fun fetchPage(search: String, page: Int) {
        this.lastQuery = search
        val subscription = repository
            .fetchPage(search, page)
            .startWith(Resource.Loading())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when (it) {
                        is Resource.Loading -> recipeState.value = RecipeState.Loading
                        is Resource.Success -> {
                            recipeState.value = RecipeState.DataFetched(it.data, page)
                            this.page++
                        }
                        is Resource.Error -> recipeState.value = RecipeState.Error(it.toString())
                        is Resource.Empty -> recipeState.value = RecipeState.Empty
                    }
                },
                {
                    recipeState.value = RecipeState.Error(it.toString())
                }
            )

        subscriptions.add(subscription)
    }


    override fun getSaved(saved: Boolean) {
        TODO("Not yet implemented")
    }

    override fun insert(recipe: Recipe) {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun filter(filter: String) {
    }



    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}