package bobby.irawan.introkoin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import bobby.irawan.introkoin.databinding.ActivityMainBinding
import bobby.irawan.introkoin.ui.model.NewsModelView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()
    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getNewsData()
        initRecyclerView()

        setViewModelObserver()
    }

    private fun initRecyclerView() {
        binding.recyclerViewNews.setHasFixedSize(true)
        binding.recyclerViewNews.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewNews.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewNews.context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerViewNews.adapter = adapter
    }

    private fun setViewModelObserver() {
        viewModel.news.observe(this, Observer {
            showData(it)
        })

        viewModel.loading.observe(this, Observer {
            isShowLoading(it)
        })
    }

    private fun isShowLoading(it: Int) {
        binding.progressBarLoading.visibility = it
    }

    private fun showData(it: NewsModelView) {
        adapter.setNews(it.articles)
    }

}
