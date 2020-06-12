package bobby.irawan.introkoin.ui.model

import java.io.Serializable

/**
 * Created by bobbyirawan09 on 02/06/20.
 */
data class NewsModelView (
    val status: String = "",
    val totalResults: Int = 0,
    val articles: List<ArticleModelView> = listOf()
): Serializable