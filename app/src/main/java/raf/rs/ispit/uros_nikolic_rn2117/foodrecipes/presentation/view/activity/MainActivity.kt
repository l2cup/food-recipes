package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.activity

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.R
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.RecipeContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.viewpager.MainActivityPagerAdapter
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.RecipeViewModel


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val recipeListViewModel: RecipeContract.ViewModel by viewModel<RecipeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initBottomNavigation()
    }

    private fun init() {
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = MainActivityPagerAdapter(supportFragmentManager)
        viewPager.currentItem = MainActivityPagerAdapter.FIRST_FRAGMENT


        search_category.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewPager.setCurrentItem(MainActivityPagerAdapter.SECOND_FRAGMENT, false)
                query?.let { recipeListViewModel.fetchPage(it, 1) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun initBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_item_1 -> {
                    viewPager.currentItem = MainActivityPagerAdapter.FIRST_FRAGMENT
                }
                R.id.navigation_item_2 -> {
                    viewPager.currentItem = MainActivityPagerAdapter.SECOND_FRAGMENT
                }
            }
            true
        }
    }

}