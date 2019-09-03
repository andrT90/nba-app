package app.nba.app.presentation.screen.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.nba.app.data.core.AppLauncher
import app.nba.app.data.navigation.AppNavigator
import app.nba.app.di.DI
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainHost : AppCompatActivity() {

    private val navigator =
        object : AppNavigator(this, android.R.id.content, supportFragmentManager) {}


    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var appLauncher: AppLauncher

    override fun onCreate(savedInstanceState: Bundle?) {
        DI.hostComponentBuilder().inject(this)
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            appLauncher.launch()
        }
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }


    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }


}
