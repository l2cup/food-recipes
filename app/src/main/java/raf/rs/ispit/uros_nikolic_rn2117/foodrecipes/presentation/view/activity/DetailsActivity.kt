package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.view.activity

import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_recipe.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.R
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.contract.RecipeDetailsContract
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.state.RecipeDetailsState
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.presentation.viewmodel.RecipeDetailsViewModel
import kotlin.math.roundToInt

class DetailsActivity : AppCompatActivity(R.layout.activity_recipe) {

    private val recipeDetailsViewModel: RecipeDetailsContract.ViewModel by viewModel<RecipeDetailsViewModel>()
    private var id: String = ""

    companion object {
        const val RECIPE_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = intent.getStringExtra(RECIPE_ID) ?: ""
        init(id)
    }

    private fun init(id: String) {

        recipeDetailsViewModel.recipeDetailsState.observe(this, Observer {
            renderState(it)
        })

        recipeDetailsViewModel.getById(id)
    }

    private fun renderState(state: RecipeDetailsState) {
        when(state) {
            is RecipeDetailsState.Success -> {
                ingredientsTA.setText(state.recipes.ingredients.joinToString(separator = "\n"), TextView.BufferType.NORMAL)
                ingredientsTV.text = state.recipes.publisher

                Picasso
                    .get()
                    .load(state.recipes.imageURL)
                    .into(recipePictureIV)

                socialTV.text = state.recipes.social.roundToInt().toString()

            }
        }
    }
}