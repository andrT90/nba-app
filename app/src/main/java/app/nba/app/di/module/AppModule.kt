package app.nba.app.di.module

import android.app.Application
import android.content.Context
import app.nba.app.data.core.ResourseManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideResourseManager(): ResourseManager = ResourseManager(application.applicationContext)
}