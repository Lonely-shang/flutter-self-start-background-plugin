import 'package:flutter_test/flutter_test.dart';
import 'package:self_start_background/self_start_background.dart';
import 'package:self_start_background/self_start_background_platform_interface.dart';
import 'package:self_start_background/self_start_background_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockSelfStartBackgroundPlatform
    with MockPlatformInterfaceMixin
    implements SelfStartBackgroundPlatform {
  @override
  Future<String> getPhoneModel() {
    // TODO: implement getPhoneModel
    throw UnimplementedError();
  }

  @override
  Future<bool> openBackgroundSetting() {
    // TODO: implement openBackgroundSetting
    throw UnimplementedError();
  }

  @override
  Future<bool> openSelfStartSetting() {
    // TODO: implement openSelfStartSetting
    throw UnimplementedError();
  }


}

void main() {
  final SelfStartBackgroundPlatform initialPlatform = SelfStartBackgroundPlatform.instance;

  test('$MethodChannelSelfStartBackground is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelSelfStartBackground>());
  });

}
