package recipe.prkale.com.recipe

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class RecipeService {

    fun getRecipe(callback: (Request, Response, Result<String, FuelError>) -> Unit) {
        //as Emulator runs in virtual env 10.0.2.2 is mapped to localhost:8080
         "http://10.0.2.2:3000/recipes".httpGet().responseString(handler = callback)
    }
}