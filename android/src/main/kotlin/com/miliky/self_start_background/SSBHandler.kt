package com.miliky.self_start_background

import android.content.Context
import com.miliky.self_start_background.ssbManager.BackgroundManager
import com.miliky.self_start_background.ssbManager.SelfStartManager
import com.miliky.self_start_background.utils.CheckPhoneModel.getPhoneModel
import com.miliky.self_start_background.utils.PhoneModel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SSBHandler(messenger: BinaryMessenger, context: Context) : MethodChannel.MethodCallHandler {

    private var context: Context
    private var methodChannel: MethodChannel? = null

    private var backgroundManager: BackgroundManager
    private var selfStartManager: SelfStartManager

    init {
       this.context = context
        backgroundManager = BackgroundManager(context)
        selfStartManager = SelfStartManager(context)
        register(messenger)
    }

    private fun register(binaryMessenger: BinaryMessenger) {
        if (methodChannel != null) dispose()
        methodChannel = MethodChannel(binaryMessenger, "com.miliky/self_start_background")
        methodChannel?.setMethodCallHandler(this)
    }

    fun dispose () {
        methodChannel?.setMethodCallHandler(null)
        methodChannel = null
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when(call.method) {
            "getPhoneModel" -> onGetPhoneModel(result)
            "openSelfStartSetting"  -> onOpenSelfStartSetting(result)
            "openBackgroundSetting" -> onOpenBackgroundSettion(result)
            else -> result.notImplemented()
        }
    }

    private fun onGetPhoneModel(result: MethodChannel.Result) {
        val phoneModel = getPhoneModel().toStrValue()
        return result.success(phoneModel)
    }

    private fun onOpenBackgroundSettion(result: MethodChannel.Result) {
        val phoneModel: PhoneModel? = getPhoneModel()
        if (phoneModel == null) {
            result.success(false)
        } else {
            var coroutineScope = CoroutineScope(Dispatchers.Main)
            coroutineScope.launch {
                val openBackgroundSetting = backgroundManager.openBackgroundSetting(phoneModel)
                result.success(openBackgroundSetting)
            }
        }
    }

    private fun onOpenSelfStartSetting(result: MethodChannel.Result) {
        val phoneModel: PhoneModel = getPhoneModel()
        if (phoneModel == PhoneModel.UNKNOWN) {
            result.success(false)
        } else {
            val openSelfStartSetting = selfStartManager.openSelfStartSetting(phoneModel)
            result.success(openSelfStartSetting)
        }
    }

}