package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.diff


import androidx.recyclerview.widget.DiffUtil
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe

class RecipeDiffItemCallback : DiffUtil.ItemCallback<Recipe>() {

    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.imageURL == newItem.imageURL &&
                oldItem.publisher == newItem.publisher &&
                oldItem.title == newItem.title &&
                oldItem.socialRank == newItem.socialRank
    }
}