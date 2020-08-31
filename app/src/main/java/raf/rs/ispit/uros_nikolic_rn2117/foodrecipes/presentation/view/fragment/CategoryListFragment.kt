package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.fragment


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.R
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.CategoryContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.RecipeContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.CategoryState
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.RecipeState
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.adapter.CategoryAdapter
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.diff.CategoryDiffItemCallback
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.viewpager.MainActivityPagerAdapter
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.CategoryViewModel
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.RecipeViewModel
import timber.log.Timber

class CategoryListFragment : Fragment(R.layout.fragment_category_list),
    CategoryAdapter.OnCategoryItemClickListener {

    private val categoriesViewModel: CategoryContract.ViewModel by sharedViewModel<CategoryViewModel>()
    private val recipeListViewModel: RecipeContract.ViewModel by sharedViewModel<RecipeViewModel>()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        categoriesRecyclerView.layoutManager = LinearLayoutManager(context)
        categoryAdapter = CategoryAdapter(CategoryDiffItemCallback(), this)
        categoriesRecyclerView.adapter = categoryAdapter

        categoriesViewModel.categoryState.observe(viewLifecycleOwner, Observer {
            renderState(it)
            Timber.e(it.toString())
        })

        categoriesViewModel.getCategories()
    }

    private fun renderState(state: CategoryState) {
        when (state) {
            is CategoryState.Success -> {
                Timber.e("Category success")
                categoryAdapter.submitList(state.categories)
            }
            is CategoryState.Error -> {
                Timber.e("Category error")
                Toast.makeText(context, state.err, Toast.LENGTH_SHORT).show()
            }
            is CategoryState.Loading -> {
                Timber.e("Categories loading")
            }
        }
    }

    override fun onItemClick(item: Category, position: Int) {
        this.activity?.let {
            it.viewPager.setCurrentItem(MainActivityPagerAdapter.SECOND_FRAGMENT, false)
            recipeListViewModel.page = 1
            recipeListViewModel.fetchPage(item.name, recipeListViewModel.page)
        }
    }


}
