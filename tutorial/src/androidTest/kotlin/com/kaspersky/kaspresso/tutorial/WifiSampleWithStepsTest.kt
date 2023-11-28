package com.kaspersky.kaspresso.tutorial

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.screen.MainScreen
import com.kaspersky.kaspresso.tutorial.screen.WifiScreen
import org.junit.Rule
import org.junit.Test

class WifiSampleWithStepsTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() {
        // Step 1. Open target screen
        MainScreen {
            wifiActivityButton {
                isVisible()
                isClickable()
                click()
            }
        }
        // Step 2. Check correct wifi status
        WifiScreen {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
            checkWifiButton.isVisible()
            checkWifiButton.isClickable()
            wifiStatus.hasEmptyText()
            checkWifiButton.click()
            wifiStatus.hasText(R.string.enabled_status)
            device.network.toggleWiFi(false)
            checkWifiButton.click()
            wifiStatus.hasText(R.string.disabled_status)
            // Step 3. Rotate device and check wifi status
            device.exploit.rotate()
            wifiStatus.hasText(R.string.disabled_status)


        }
    }
}
