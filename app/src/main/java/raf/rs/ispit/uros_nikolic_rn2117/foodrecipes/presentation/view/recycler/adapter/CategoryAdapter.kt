package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.R
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.diff.CategoryDiffItemCallback
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.viewholder.CategoryViewHolder


class CategoryAdapter(
    categoryDiffItemCallback: CategoryDiffItemCallback,
    private val clickListener: OnCategoryItemClickListener
) : ListAdapter<Category, CategoryViewHolder>(categoryDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.viewholder_categories, parent, false)
        return CategoryViewHolder(containerView)
    }

    override fun onBindViewHolder(categoryViewHolder: CategoryViewHolder, position: Int) {

        val category = getItem(position)

        categoryViewHolder.bind(category)
        categoryViewHolder.init(category, clickListener)

    }

    interface OnCategoryItemClickListener {
        fun onItemClick(item: Category, position: Int)
    }

}