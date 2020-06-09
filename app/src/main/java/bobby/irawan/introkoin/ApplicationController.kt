package bobby.irawan.introkoin

import android.app.Application
import bobby.irawan.introkoin.di.repositoryModule
import bobby.irawan.introkoin.di.retrofitModule
import bobby.irawan.introkoin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by bobbyirawan09 on 02/06/20.
 */
class ApplicationController: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@ApplicationController)
            modules(
                listOf(
                    repositoryModule,
                    retrofitModule,
                    viewModelModule
                )
            )
        }
    }
}