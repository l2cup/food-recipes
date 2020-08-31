package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.fragment.CategoryListFragment
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.fragment.RecipeListFragment
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.fragment.SavedFragment

class MainActivityPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 2
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            FIRST_FRAGMENT -> CategoryListFragment()
            SECOND_FRAGMENT -> RecipeListFragment()
            else -> SavedFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            FIRST_FRAGMENT -> "Categories"
            SECOND_FRAGMENT -> "Recipes"
            else -> "Saved"
        }
    }
}