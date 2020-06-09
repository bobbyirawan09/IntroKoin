package bobby.irawan.introkoin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import bobby.irawan.introkoin.databinding.LayoutNewsBinding
import bobby.irawan.introkoin.ui.model.ArticleModelView
import coil.api.load

/**
 * Created by bobbyirawan09 on 02/06/20.
 */
class MainAdapter: RecyclerView.Adapter<MainAdapter.NewsViewHolder>() {

    private var news: List<ArticleModelView> = listOf()

    fun setNews(news: List<ArticleModelView>) {
        this.news = news
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = LayoutNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }

    class NewsViewHolder(private val binding: LayoutNewsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticleModelView) {
            binding.imageViewNews.load(article.urlToImage)
            binding.textViewNewsDescription.text = article.description
            binding.textViewTitle.text = article.title
            binding.textViewNewsAuthor.text = article.author
        }
    }
}