package app.nba.app

import android.app.Application
import app.nba.app.di.DI
import com.jakewharton.threetenabp.AndroidThreeTen

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

        DI.init(this)
    }
}