package bobby.irawan.introkoin.repository

import bobby.irawan.introkoin.ui.model.NewsModelView

/**
 * Created by bobbyirawan09 on 02/06/20.
 */
interface NewsRepositoryContract {

    suspend fun getNews(): NewsModelView
}