package recipe.prkale.com.recipe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //increase performance..size of card will not change when new item is edited or removed
        rv.setHasFixedSize(true);
        rv.layoutManager = LinearLayoutManager(this)

       val func = {
           request:Request, response:Response, result:Result<String, FuelError> ->
           when(result){
               is Result.Failure -> {
                   val ex = result.getException()

               }
               is Result.Success -> {
                   val data = result.get()
                   val recipeList = Gson().fromJson(data, RecipeList::class.java)
                   rv.adapter = RecipeViewAdaptor(recipeList.recipes)
               }
           }
       }

        RecipeService().getRecipe(callback = func)

    }
}
