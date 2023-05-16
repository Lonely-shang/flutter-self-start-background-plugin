import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'self_start_background_platform_interface.dart';

/// An implementation of [SelfStartBackgroundPlatform] that uses method channels.
class MethodChannelSelfStartBackground extends SelfStartBackgroundPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('com.miliky/self_start_background');

  @override
  Future<String> getPhoneModel() async {
    var invokeMethod = await methodChannel.invokeMethod("getPhoneModel");
    return invokeMethod;
  }

  @override
  Future<bool> openBackgroundSetting() async{
    return await methodChannel.invokeMethod("openSelfStartSetting");
  }

  @override
  Future<bool> openSelfStartSetting() async{
    return await methodChannel.invokeMethod("openBackgroundSetting");
  }

}
