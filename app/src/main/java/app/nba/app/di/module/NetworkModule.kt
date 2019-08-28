package app.nba.app.di.module

import app.nba.app.BuildConfig
import app.nba.app.data.net.TeamService
import app.nba.app.data.net.interceptor.AuthInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
        }
        builder
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthInterceptor())

        return builder.build()

    }

    @Provides
    @Singleton
    fun provideTeamService(
        client: OkHttpClient,
        gson: Gson
    ): TeamService = Retrofit.Builder()
        .baseUrl("https://free-nba.p.rapidapi.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()
        .create(TeamService::class.java)
}