package com.miliky.self_start_background.ssbManager

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
import com.miliky.self_start_background.utils.PhoneModel

/**
 * Mobile Self Start Setting Info
 *
 * @Author: Miliky
 * @Date: 2023/5/16 9:37
 * @Description: [爱意随风起，风止意难平。]
 */
class SelfStartManager {

    private val context: Context

    constructor(context: Context) {
        this.context = context
    }

    /**
     * GoTo Open SelfStart Setting Layout
     *
     * @param: PhoneModel
     * @return:
     * @auther: Miliky
     * @date: 2023/5/12 9:30
     */
    fun openSelfStartSetting (phoneModel: PhoneModel): Boolean {
        return when(phoneModel) {
            PhoneModel.HUAWEI -> openHuaweiSelfStartSetting()
            PhoneModel.XIAOMI -> openXiaomiSelfStartSetting()
            PhoneModel.VIVO -> openVivoSelfStartSetting()
            PhoneModel.OPPO -> openOppoSelfStartSetting()
            else -> false
        }
    }

    private fun openOppoSelfStartSetting(): Boolean {
        return try {
            val intent = Intent()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                intent.action = "android.settings.APPLICATION_DETAILS_SETTINGS";
                intent.data = Uri.fromParts("package", context.packageName, null);
            } else {
                intent.action = Intent.ACTION_VIEW;
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra("com.android.settings.ApplicationPkgName", context.packageName);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(context, intent, null)
            true
        } catch (e: Exception) {
            println(e.message)
            false
        }

    }

    private fun openVivoSelfStartSetting(): Boolean {
        return try {
            val intent = Intent()
            intent.component = ComponentName(
                "com.vivo.permissionmanager",
                "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
            )
            context.startActivity(intent)
            true
        } catch (e: Exception) { false }
    }

    private fun openXiaomiSelfStartSetting(): Boolean {
        return try {
            val intent = Intent()
            intent.component = ComponentName(
                "com.miui.securitycenter",
                "com.miui.permcenter.autostart.AutoStartManagementActivity"
            )
            context.startActivity(intent)
            true
        } catch (e: Exception) { false }
    }

    private fun openHuaweiSelfStartSetting(): Boolean {
        return try {
            val intent = Intent()
            intent.component = ComponentName(
                "com.huawei.systemmanager",
                "com.huawei.systemmanager.mainscreen.MainScreenActivity"
            )
            context.startActivity(intent)
            true
        } catch (e: Exception) { false }
    }
}