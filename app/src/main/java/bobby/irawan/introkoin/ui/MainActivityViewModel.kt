package bobby.irawan.introkoin.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bobby.irawan.introkoin.repository.NewsRepositoryContract
import bobby.irawan.introkoin.ui.model.NewsModelView
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

/**
 * Created by bobbyirawan09 on 02/06/20.
 */
class MainActivityViewModel(private val repository: NewsRepositoryContract): ViewModel() {

    private val coroutineScope = viewModelScope + Main

    private val _news = MutableLiveData<NewsModelView>()
    val news: LiveData<NewsModelView>
        get() = _news

    private val _loading = MutableLiveData<Int>()
    val loading: LiveData<Int>
        get() = _loading

    fun getNewsData() {
        coroutineScope.launch {
            _news.value = repository.getNews()
            _loading.value = View.GONE
        }
    }

}