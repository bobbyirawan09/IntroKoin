package bobby.irawan.introkoin.ui.model

import java.io.Serializable

data class ArticleModelView (
    val source: SourceModelView? = null,
    val author: String? = "",
    val title: String? = "",
    val description: String? = "",
    val url: String? = "",
    val urlToImage: String? = "",
    val publishedAt: String? = "",
    val content: String? = ""
): Serializable
