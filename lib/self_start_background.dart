
import 'self_start_background_platform_interface.dart';

class SelfStartBackground {

  static Future<String> get getPhoneModel async{
    return await SelfStartBackgroundPlatform.instance.getPhoneModel();
  }

  static Future<bool> get openSelfStartSetting async{
    return await SelfStartBackgroundPlatform.instance.openSelfStartSetting();
  }

  static Future<bool> get openBackgroundSetting async{
    return await SelfStartBackgroundPlatform.instance.openBackgroundSetting();
  }

}
