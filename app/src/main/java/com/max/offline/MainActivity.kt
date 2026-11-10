package com.max.offline

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private val navy = Color.rgb(15, 27, 48)
    private val teal = Color.rgb(0, 150, 145)

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = navy
        window.navigationBarColor = navy

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(20), dp(16), dp(16))
            setBackgroundColor(Color.rgb(245, 247, 250))
        }

        val header = TextView(this).apply {
            text = "MAX"
            textSize = 32f
            setTextColor(navy)
            gravity = Gravity.CENTER_VERTICAL
        }
        page.addView(header, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(64)))
        page.addView(label("PRIVATE • OFFLINE • NO SUBSCRIPTION", teal, 13f))
        page.addView(spacer(20))

        page.addView(section("Welcome to MAX",
            "This is the secure offline project foundation. No network permission is declared."))
        page.addView(section("Voice Assistant",
            "Not yet implemented. Offline speech and wake-word components require separate model and device testing."))
        page.addView(section("Automation",
            "Not yet implemented. Accessibility access will only be added for specific, consent-based tasks."))
        page.addView(section("Local Data",
            "Encrypted storage foundation is included in the source project."))
        page.addView(section("Backup & Restore",
            "Not yet implemented. Backup format and recovery tests are required before storing important data."))

        val footer = TextView(this).apply {
            text = "MAX • Version 0.1.0 • Development build"
            textSize = 12f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(0, dp(16), 0, 0)
        }
        page.addView(
            footer,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        // Targeting SDK 35 draws the app edge-to-edge. fitsSystemWindows keeps the
        // content clear of the status/navigation bars; the navy background fills them.
        val scroll = ScrollView(this).apply {
            setBackgroundColor(navy)
            isFillViewport = true
            fitsSystemWindows = true
            addView(page)
        }
        setContentView(scroll)
    }

    private fun label(text: String, color: Int, size: Float): TextView = TextView(this).apply {
        this.text = text
        textSize = size
        setTextColor(color)
    }

    private fun spacer(heightDp: Int): TextView = TextView(this).apply {
        height = dp(heightDp)
    }

    private fun section(title: String, detail: String): TextView =
        TextView(this).apply {
            text = "$title\n$detail"
            textSize = 15f
            setTextColor(navy)
            setPadding(dp(14), dp(14), dp(14), dp(14))
            setBackgroundColor(Color.WHITE)
            elevation = dp(2).toFloat()
            val p = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            p.bottomMargin = dp(10)
            layoutParams = p
        }
}
