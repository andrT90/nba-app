package app.nba.app.data.core

import app.nba.app.data.navigation.screen.ConferenceScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AppLauncher @Inject constructor(private val router: Router) {

    fun launch() = router.newRootChain(ConferenceScreen())
}