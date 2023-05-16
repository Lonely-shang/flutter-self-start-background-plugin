import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:self_start_background/self_start_background_method_channel.dart';

void main() {
  MethodChannelSelfStartBackground platform = MethodChannelSelfStartBackground();
  const MethodChannel channel = MethodChannel('com.miliky/self_start_background');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });


}
