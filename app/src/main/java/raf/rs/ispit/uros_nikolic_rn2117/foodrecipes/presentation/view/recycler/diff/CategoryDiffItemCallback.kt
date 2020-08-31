package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.diff


import androidx.recyclerview.widget.DiffUtil
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category

class CategoryDiffItemCallback : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.name == newItem.name &&
                oldItem.imageURL == newItem.imageURL
    }
}