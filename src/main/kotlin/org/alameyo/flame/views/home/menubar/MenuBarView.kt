package org.alameyo.flame.views.home.menubar

import org.alameyo.flame.controllers.FlameController
import org.alameyo.flame.views.home.FlameApplicationView
import org.alameyo.flame.views.login.MainView
import tornadofx.*

class MenuBarView: View() {

    private val connection = tornadofx.find<FlameController>().connection

    override val root = menubar {
        menu("Settings") {
            item("Log out") {
                action {
                    connection.disconnect()
                    find<FlameApplicationView>().replaceWith<MainView>(ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
                }
            }
        }
    }
}