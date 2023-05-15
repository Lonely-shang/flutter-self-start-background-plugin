package com.miliky.self_start_background.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Get App Info Utils
 *
 * @Author: Miliky
 * @Date: 2023/5/15 14:52
 * @Description: [爱意随风起，风止意难平。]
 */
class AppUtils {
    companion object {
        fun PackageManager.getPackageInfoCompat(packageName: String, flags: Int = 0): PackageInfo =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(flags.toLong()))
            } else {
                @Suppress("DEPRECATION") getPackageInfo(packageName, flags)
            }

        /** get app Name
         *
         * @param: Context
         * @return: String
         * @auther: Miliky
         * @date: 2023/5/11 16:20
         */
        suspend fun getAppName (context: Context): String = suspendCoroutine { cont ->
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfoCompat(context.packageName, 0)
//                val labelRes = packageInfo.applicationInfo.labelRes
//                val appName = context.resources.getString(labelRes)
                var appName = packageInfo.applicationInfo.nonLocalizedLabel as String
                cont.resume(appName)
            } catch (e: Exception) {
                cont.resume("Known")
            }

        }

        /**  get app version name
         *
         * @param: context
         * @return: String
         * @auther: Miliky
         * @date: 2023/5/11 16:19
         */
        suspend fun getVersionName (context: Context): String = suspendCoroutine {cont ->
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfoCompat(context.packageName, 0)
                cont.resume(packageInfo.versionName)
            } catch (e: Exception) {
                cont.resume("")
            }
        }

        /** get app version code
         *
         * @param: [Context] context
         * @return: [String]
         * @auther: Miliky
         * @date: 2023/5/11 16:29
         */
        @Suppress("DEPRECATION")
        suspend fun getVersionCode(context: Context): Int = suspendCoroutine { cont ->
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfoCompat(context.packageName, 0)
                cont.resume(packageInfo.versionCode)
            } catch (e: Exception) {
                cont.resumeWithException(e)
            }
        }

        /** get app package name
         *
         * @param: Context
         * @return: [String] packageName
         * @auther: Miliky
         * @date: 2023/5/11 16:29
         */
        suspend fun getPackageName(context: Context): String = suspendCoroutine {cont ->
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfoCompat(context.packageName, 0)
                cont.resume(packageInfo.packageName)
            } catch (e: Exception) {
                cont.resumeWithException(e)
            }
        }
    }
}