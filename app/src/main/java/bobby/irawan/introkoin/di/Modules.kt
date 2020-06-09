package bobby.irawan.introkoin.di

import bobby.irawan.introkoin.Constants.BASE_URL
import bobby.irawan.introkoin.data.ApiService
import bobby.irawan.introkoin.repository.NewsRepository
import bobby.irawan.introkoin.repository.NewsRepositoryContract
import bobby.irawan.introkoin.ui.MainActivityViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by bobbyirawan09 on 02/06/20.
 */

val retrofitModule = module {

    fun provideHttpClient() =
        OkHttpClient().newBuilder().build()

    fun provideRetrofit(httpClient: OkHttpClient) =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    single { provideRetrofit(get()) }
    single { provideHttpClient() }
    single { provideApiService(get()) }
}

val repositoryModule = module {
    single<NewsRepositoryContract> {
        NewsRepository(get())
    }
}

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
    }
}