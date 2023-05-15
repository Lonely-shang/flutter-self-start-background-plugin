import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'self_start_background_platform_interface.dart';

/// An implementation of [SelfStartBackgroundPlatform] that uses method channels.
class MethodChannelSelfStartBackground extends SelfStartBackgroundPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('self_start_background');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
