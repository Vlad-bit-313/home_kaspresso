package com.kaspersky.kaspresso.tutorial.screen

import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object NotificationScreen : UiScreen<NotificationScreen>() {

    override val packageName: String = "com.android.systemui"

//    val title = UiTextView {withId(this@NotificationScreen.packageName, "title") }
//    val content = UiTextView {withId(this@NotificationScreen.packageName, "text") }

    // либо можно так
         val title = UiTextView { withId("android", "title") }
        val content = UiTextView { withId("android", "text") }
}
