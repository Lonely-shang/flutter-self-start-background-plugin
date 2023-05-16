import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'self_start_background_method_channel.dart';

abstract class SelfStartBackgroundPlatform extends PlatformInterface {
  /// Constructs a SelfStartBackgroundPlatform.
  SelfStartBackgroundPlatform() : super(token: _token);

  static final Object _token = Object();

  static SelfStartBackgroundPlatform _instance = MethodChannelSelfStartBackground();

  /// The default instance of [SelfStartBackgroundPlatform] to use.
  ///
  /// Defaults to [MethodChannelSelfStartBackground].
  static SelfStartBackgroundPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [SelfStartBackgroundPlatform] when
  /// they register themselves.
  static set instance(SelfStartBackgroundPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }


  Future<String> getPhoneModel() {
    throw UnimplementedError('getPhoneModel() has not been implemented.');
  }

  Future<bool> openSelfStartSetting() {
    throw UnimplementedError('openSelfStartSetting() has not been implemented.');
  }

  Future<bool> openBackgroundSetting() {
    throw UnimplementedError('openBackgroundSetting() has not been implemented.');
  }

}
