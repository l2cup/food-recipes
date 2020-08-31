package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.R
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.diff.RecipeDiffItemCallback
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.viewholder.RecipeViewHolder


class RecipeAdapter(
    recipeDiffItemCallback: RecipeDiffItemCallback,
    private val clickListener: OnRecipeItemClickListener
) : ListAdapter<Recipe, RecipeViewHolder>(recipeDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.viewholder_recipes, parent, false)
        return RecipeViewHolder(containerView)
    }


    interface OnRecipeItemClickListener {
        fun onItemClick(item: Recipe, position: Int)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
        holder.init(recipe, clickListener)

    }


}