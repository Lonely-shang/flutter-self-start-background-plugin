package com.miliky.self_start_background

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel

/** SelfStartBackgroundPlugin */
class SelfStartBackgroundPlugin: FlutterPlugin {

  private var ssbHandler: SSBHandler? = null

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    ssbHandler = SSBHandler(flutterPluginBinding.binaryMessenger, flutterPluginBinding.applicationContext)
  }


  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    ssbHandler?.dispose()
    ssbHandler = null
  }
}
