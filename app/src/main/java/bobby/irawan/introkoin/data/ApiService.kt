package bobby.irawan.introkoin.data

import bobby.irawan.introkoin.Constants.URL_SEARCH
import bobby.irawan.introkoin.ui.model.NewsModelView
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by bobbyirawan09 on 02/06/20.
 */
interface ApiService {

    @GET(URL_SEARCH)
    suspend fun getNews(): NewsModelView
}