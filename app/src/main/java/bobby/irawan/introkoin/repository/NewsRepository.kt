package bobby.irawan.introkoin.repository

import bobby.irawan.introkoin.data.ApiService
import bobby.irawan.introkoin.ui.model.NewsModelView

/**
 * Created by bobbyirawan09 on 02/06/20.
 */
class NewsRepository(private val api: ApiService) : NewsRepositoryContract {
    override suspend fun getNews(): NewsModelView = api.getNews()
}