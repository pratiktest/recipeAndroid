package recipe.prkale.com.recipe

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recipe.view.*

class RecipeViewAdaptor(val recipes: List<Recipe>) : RecyclerView.Adapter<RecipeViewAdaptor.RecipeViewHolder>()  {

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        if(holder != null){
            holder.view.recipeTitle.text = recipes[position].title
            holder.view.recipeDescription.text = recipes[position].description

            val imageUrl = "http://10.0.2.2:3000/images/"+recipes[position].image

            Glide.with(holder.view).load(imageUrl).into(holder.view.recipeImage);

            holder.itemView.setOnClickListener {

                Toast.makeText(it.getContext(), "Recycle Click" + position, Toast.LENGTH_SHORT).show();
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view =  LayoutInflater.from(parent?.context).inflate(R.layout.recipe, parent, false)
        return RecipeViewHolder(view);
    }

    //View holder minimizes call to find view by id which improves performance
    class RecipeViewHolder(val view: View): RecyclerView.ViewHolder(view){

    }


    override fun getItemCount(): Int {
        return recipes.size
    }

}