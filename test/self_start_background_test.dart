import 'package:flutter_test/flutter_test.dart';
import 'package:self_start_background/self_start_background.dart';
import 'package:self_start_background/self_start_background_platform_interface.dart';
import 'package:self_start_background/self_start_background_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockSelfStartBackgroundPlatform
    with MockPlatformInterfaceMixin
    implements SelfStartBackgroundPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final SelfStartBackgroundPlatform initialPlatform = SelfStartBackgroundPlatform.instance;

  test('$MethodChannelSelfStartBackground is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelSelfStartBackground>());
  });

  test('getPlatformVersion', () async {
    SelfStartBackground selfStartBackgroundPlugin = SelfStartBackground();
    MockSelfStartBackgroundPlatform fakePlatform = MockSelfStartBackgroundPlatform();
    SelfStartBackgroundPlatform.instance = fakePlatform;

    expect(await selfStartBackgroundPlugin.getPlatformVersion(), '42');
  });
}
