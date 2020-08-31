package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.viewholder_categories.*
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.recycler.adapter.CategoryAdapter

class CategoryViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun init(item: Category, action: CategoryAdapter.OnCategoryItemClickListener) {
        containerView.setOnClickListener {
            action.onItemClick(item, adapterPosition)
        }
    }

    fun bind(category: Category) {
        Picasso
            .get()
            .load(category.imageURL)
            .into(categoryPicture)
        nameTV.text = category.name
    }

}