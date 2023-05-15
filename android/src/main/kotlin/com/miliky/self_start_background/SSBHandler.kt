package com.miliky.self_start_background

import android.content.Context
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler

class SSBHandler(messenger: BinaryMessenger, context: Context) : MethodCallHandler {

    private var context: Context
    private var methodChannel: MethodChannel? = null

    init {
       this.context = context
        if (methodChannel != null) dispose()
        methodChannel = MethodChannel(messenger, "com.miliky/self_start_background")
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

    }

    private fun onOpenSelfStartSetting(result: MethodChannel.Result) {
        TODO("Not yet implemented")
    }

    private fun onOpenBackgroundSettion(result: MethodChannel.Result) {
        TODO("Not yet implemented")
    }

}