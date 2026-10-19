
package com.ankitapatra.campuseventexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ankitapatra.campuseventexplorer.data.CampusEventRepository
import com.ankitapatra.campuseventexplorer.data.EventRepository
import com.ankitapatra.campuseventexplorer.navigation.EventNavGraph
import com.ankitapatra.campuseventexplorer.ui.theme.CampusEventExplorerTheme
import com.ankitapatra.campuseventexplorer.util.EventShareHelper
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {

    private val repository: EventRepository = CampusEventRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = false

        setContent {
            CampusEventExplorerTheme {
                EventNavGraph(
                    onShareEvent = { eventId ->

                        val event = repository.getEventById(eventId)

                        if (event != null) {
                            EventShareHelper.shareEvent(
                                context = this,
                                event = event
                            )
                        }
                    }
                )
            }
        }
    }
}
