package app.nba.app.presentation.screen.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import app.nba.app.R
import app.nba.app.data.core.AppLauncher
import app.nba.app.data.navigation.AppNavigator
import app.nba.app.di.DI
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class MainHost : AppCompatActivity() {

    private val navigator =
        object : AppNavigator(this, android.R.id.content, supportFragmentManager) {
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {
                fragmentTransaction?.setCustomAnimations(
                    R.anim.fade_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.fade_out
                )
            }
        }


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
