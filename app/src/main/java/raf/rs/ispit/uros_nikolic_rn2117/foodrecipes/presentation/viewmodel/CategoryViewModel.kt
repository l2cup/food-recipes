package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.Resource
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.repositories.categories.CategoryRepository
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.CategoryContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.CategoryState

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel(),
    CategoryContract.ViewModel {


    override val categoryState: MutableLiveData<CategoryState> = MutableLiveData()
    private val subscriptions = CompositeDisposable()


    override fun getCategories() {
        val subscription = repository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    when (it) {
                        is Resource.Success -> categoryState.value = CategoryState.Success(it.data)
                    }
                },
                {
                    categoryState.value = CategoryState.Error(it.toString())
                })

        subscriptions.add(subscription)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}
