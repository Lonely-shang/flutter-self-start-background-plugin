import 'package:self_start_background/data/phone_model.dart';
import 'package:self_start_background/utils/handler_result.dart';

import 'self_start_background_platform_interface.dart';

class SelfStartBackground {
  static Future<PhoneModel> get getPhoneModel async {
    var val = await SelfStartBackgroundPlatform.instance.getPhoneModel();
    return formatVal(val);
  }

  static Future<bool> get openSelfStartSetting async {
    return await SelfStartBackgroundPlatform.instance.openSelfStartSetting();
  }

  static Future<bool> get openBackgroundSetting async {
    return await SelfStartBackgroundPlatform.instance.openBackgroundSetting();
  }
}
