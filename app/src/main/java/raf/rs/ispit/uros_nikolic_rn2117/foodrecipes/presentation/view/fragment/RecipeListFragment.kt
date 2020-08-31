package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_recipe_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.R
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.RecipeContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.RecipeState
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.adapter.RecipeAdapter
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.diff.RecipeDiffItemCallback
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.RecipeViewModel
import timber.log.Timber

class RecipeListFragment : Fragment(R.layout.fragment_recipe_list),
    RecipeAdapter.OnRecipeItemClickListener {

    private val recipeListViewModel: RecipeContract.ViewModel by sharedViewModel<RecipeViewModel>()
    private lateinit var recipeAdapter: RecipeAdapter
    var loading: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recipeAdapter = RecipeAdapter(RecipeDiffItemCallback(), this)
        recyclerView.adapter = recipeAdapter

        var pastItems: Int?
        var visibleItems: Int?
        var totalItems: Int?

        /* TODO Replace snippet with a better one, better null checking*/
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    visibleItems = recyclerView.layoutManager?.childCount
                    totalItems = recyclerView.layoutManager?.itemCount
                    pastItems =
                        (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                    if (loading) {
                        if (visibleItems?.plus(pastItems!!)!! >= totalItems!!) {
                            loading = false

                            Timber.e("PAGE PAGE PAGE PAGE %s", recipeListViewModel.page)

                            recipeListViewModel.fetchPage(
                                recipeListViewModel.lastQuery,
                                recipeListViewModel.page
                            )
                        }
                    }
                } else {
                    message.isVisible = false
                    loading = true
                }
            }
        })

        this.activity.let {
            recipeListViewModel.recipeState.observe(viewLifecycleOwner, Observer {
                renderState(it)
                Timber.e(it.toString())
            })
        }


        recipeListViewModel.getAll()
        recipeListViewModel.fetchPage("", 1)
    }

    private fun renderState(state: RecipeState) {
        when (state) {
            is RecipeState.DataFetched -> {
                Toast.makeText(context, "Recipes fetched!", Toast.LENGTH_SHORT).show()
                loadingPb.isVisible = false
            }
            is RecipeState.Success -> {
                Timber.e("Recipes success")
                recipeAdapter.submitList(state.recipes.recipes)
                loadingPb.isVisible = false
            }
            is RecipeState.Error -> {
                Timber.e("Recipes error")
                Toast.makeText(context, state.err, Toast.LENGTH_SHORT).show()
                loadingPb.isVisible = false
            }
            is RecipeState.Loading -> {
                Timber.e("Recipes loading")
                loadingPb.isVisible = true
            }
            is RecipeState.Empty -> {
                Timber.e("No more")
                message.isVisible = true
                loadingPb.isVisible = false
            }
        }
    }

    override fun onItemClick(item: Recipe, position: Int) {
        /*
         this.activity?.let {
             val intent = Intent(it, DetailsActivity::class.java)
             intent.putExtra(DetailsActivity.RECIPE_ID, item.id)
             startActivity(Intent())
         }

         */

        Timber.e("ITEM ITEM %s", item.title)
    }

}