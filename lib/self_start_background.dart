
import 'self_start_background_platform_interface.dart';

class SelfStartBackground {
  Future<String?> getPlatformVersion() {
    return SelfStartBackgroundPlatform.instance.getPlatformVersion();
  }
}
