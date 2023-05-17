import 'package:self_start_background/self_start_background.dart';
import 'package:self_start_background/self_start_background_platform_interface.dart';

enum PhoneModel {
  ZTE,
  VIVO,
  SONY,
  OPPO,
  MEIZU,
  HUAWEI,
  XIAOMI,
  LENOVO,
  SAMSUNG,
  COOLPAD,
  UNKNOWN;

  Future<String> value() async {
    return await SelfStartBackgroundPlatform.instance.getPhoneModel();
  }
}
