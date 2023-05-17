package com.miliky.self_start_background.ssbManager

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
import com.miliky.self_start_background.utils.AppUtils
import com.miliky.self_start_background.utils.PhoneModel

/**
 *
 *
 * @Author: Miliky
 * @Date: 2023/5/16 9:26
 * @Description: [爱意随风起，风止意难平。]
 */
class BackgroundManager {

    private val context: Context

    constructor(context: Context) {
        this.context = context
    }

    suspend fun openBackgroundSetting (phoneModel: PhoneModel): Boolean {
       return when (phoneModel) {
           PhoneModel.HUAWEI -> openHuaweiBgSetting()
           PhoneModel.XIAOMI -> openXiaomiBgSetting()
           PhoneModel.VIVO -> openVivoBgSetting()
           PhoneModel.OPPO -> openOppoBgSetting()
           PhoneModel.MEIZU -> openMeizuBgSetting()
           else -> false
       }
    }

    /**
     * 魅族手机需要跳转到手机管家页面
     * @param:
     * @return:
     * @auther: Miliky
     * @date: 2023/5/11 17:13
     */
    private fun openMeizuBgSetting(): Boolean {
        return try {
            val packageManager = context.packageManager
            val intent: Intent? = packageManager.getLaunchIntentForPackage("com.meizu.safe")
            intent?.let { context.startActivity(it) }
            true
        } catch (e: Exception) { false }
    }

    private fun openOppoBgSetting(): Boolean {
        return try {
            val intent = Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(context, intent, null)
            true
        } catch (e: Exception) { false }
    }

    private fun openVivoBgSetting(): Boolean {
        return try {
            val intent = Intent()
            intent.component = ComponentName(
                "com.iqoo.powersaving",
                "com.iqoo.powersaving.PowerSavingManagerActivity"
            )
            context.startActivity(intent)
            true
        } catch (e: Exception) { false }
    }

    private suspend fun openXiaomiBgSetting(): Boolean{
        return try {
            val intent = Intent("miui.intent.action.APP_PERM_EDITOR")
            intent.action = "miui.intent.action.HIDDEN_APPS_CONFIG_ACTIVITY";
            intent.putExtra("package_name", context.packageName);
            intent.putExtra("package_label", AppUtils.getAppName(context));
            intent.putExtra(Settings.EXTRA_CHANNEL_ID, context.applicationInfo.uid);
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * 华为手机也需要跳转到手机管家， 新版本无法跳转到后台启动管理列表
     * @param:
     * @return:
     * @auther: Miliky
     * @date: 2023/5/11 17:15
     */
    private fun openHuaweiBgSetting (): Boolean {
        // com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity
        return try {
            val intent = Intent()
            intent.component = ComponentName(
                "com.huawei.systemmanager",
                "com.huawei.systemmanager.mainscreen.MainScreenActivity"
            )
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

}