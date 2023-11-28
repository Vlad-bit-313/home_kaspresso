package com.kaspersky.kaspresso.tutorial

import com.kaspersky.kaspresso.internal.exceptions.AdbServerException
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test

class AdbTest : TestCase() {

    @Test
    fun test() {
//        val command = "undefined_command"
//        try {
//            adbServer.performAdb(command)
//        } catch (e: AdbServerException) {
//            Assert.assertTrue("unknown command $command" in e.message)
//        }

        val command = "pm list packages ${device.targetContext.packageName}"

        val result = adbServer.performShell(command)
        assertTrue("package:${device.targetContext.packageName}" in result.first())

        val hostname = adbServer.performCmd("hostname")
        Assert.assertTrue(hostname.isNotEmpty())
    }
}


//package com.kaspersky.kaspressample.device_tests
//
//import android.Manifest
//import androidx.test.rule.GrantPermissionRule
//import com.kaspersky.kaspresso.internal.exceptions.AdbServerException
//import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
//import org.junit.Assert.assertTrue
//import org.junit.Rule
//import org.junit.Test
//
//class DeviceServerSampleTest : TestCase() {
//
//    @get:Rule
//    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
//        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//        Manifest.permission.READ_EXTERNAL_STORAGE
//    )
//
//    @Test
//    fun serverSampleTest() {
//        run {
//
//            step("Execute command on host") {
//                val result = adbServer.performCmd("hostname")
//                assertTrue(result.isNotEmpty())
//            }
//
//            step("Execute ADB command") {
//                val command = "undefined_command"
//
//                try {
//                    adbServer.performAdb(command)
//                } catch (ex: AdbServerException) {
//                    assertTrue("unknown command $command" in ex.message)
//                }
//            }
//
//            step("Execute ADB Shell command") {
//                val command = "pm list packages ${device.targetContext.packageName}"
//
//                val result = adbServer.performShell(command)
//                assertTrue("package:${device.targetContext.packageName}" in result.first())
//            }
//            val packages = adbServer.performShell("pm list packages")
//            Assert.assertTrue(device.targetContext.packageName in packages.first())
//        }
//    }
//}
