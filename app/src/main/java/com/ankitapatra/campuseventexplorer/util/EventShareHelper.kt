
package com.ankitapatra.campuseventexplorer.util

import android.content.Context
import android.content.Intent
import com.ankitapatra.campuseventexplorer.model.CampusEvent

object EventShareHelper {

    fun shareEvent(
        context: Context,
        event: CampusEvent
    ) {
        val shareText = buildString {
            appendLine("🎓 ${event.title}")
            appendLine()
            appendLine("📅 ${event.time}")
            appendLine("📍 ${event.location}")
            appendLine("🏷️ ${event.category}")
            appendLine()
            appendLine(event.description)
        }

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }

        val chooser = Intent.createChooser(
            shareIntent,
            "Share campus event"
        )

        context.startActivity(chooser)
    }
}
