package app.nba.app.presentation.screen.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.nba.app.R
import app.nba.app.data.core.AppLauncher
import app.nba.app.data.navigation.AppNavigator
import app.nba.app.di.DI
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainHost : AppCompatActivity() {

    private val navigator = object : AppNavigator(this, R.id.container, supportFragmentManager) {}


    @Inject
    lateinit var navigationHolder: NavigatorHolder

    @Inject
    lateinit var appLauncher: AppLauncher

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.hostComponentBuilder().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        if (savedInstanceState == null) {
            appLauncher.launch()
        }
    }


    override fun onPause() {
        navigationHolder.setNavigator(navigator)
        super.onPause()
    }


    override fun onResume() {
        super.onResume()
        navigationHolder.removeNavigator()
    }


}
