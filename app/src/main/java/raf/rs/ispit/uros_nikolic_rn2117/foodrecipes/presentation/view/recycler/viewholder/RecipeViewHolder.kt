package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.viewholder_recipes.*
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Recipe
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.adapter.RecipeAdapter
import kotlin.math.roundToInt

class RecipeViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun init(item: Recipe, action: RecipeAdapter.OnRecipeItemClickListener) {
        containerView.setOnClickListener {
            action.onItemClick(item, adapterPosition)
        }
    }

    fun bind(recipe: Recipe) {
        Picasso
            .get()
            .load(recipe.imageURL)
            .into(recipePictureIV)
        recipeNameTV.text = recipe.title
        socialRankTV.text = recipe.socialRank.roundToInt().toString()
        publisherTV.text = recipe.publisher

    }

}