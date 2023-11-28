package com.kaspersky.kaspresso.tutorial.screen
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import com.kaspersky.kaspresso.tutorial.R
import io.github.kakaocup.kakao.text.KTextView

object MainScreen: KScreen<MainScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val simpleActivityButton = KButton {withId(R.id.simple_activity_btn) }
    val wifiActivityButton = KButton { withId(R.id.wifi_activity_btn) }
    val loginActivityButton = KButton {withId(R.id.login_activity_btn) }
}