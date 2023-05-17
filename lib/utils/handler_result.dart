import '../data/phone_model.dart';

PhoneModel formatVal(dynamic val) {
  switch (val.toString()) {
    case "zte":
      return PhoneModel.ZTE;
    case "vivo":
      return PhoneModel.VIVO;
    case "sony":
      return PhoneModel.SONY;
    case "oppo":
      return PhoneModel.OPPO;
    case "meizu":
      return PhoneModel.MEIZU;
    case "huawei":
      return PhoneModel.HUAWEI;
    case "xiaomi":
      return PhoneModel.XIAOMI;
    case "lenovo":
      return PhoneModel.LENOVO;
    case "samsung":
      return PhoneModel.SAMSUNG;
    case "coolpad":
      return PhoneModel.COOLPAD;
    default:
      return PhoneModel.UNKNOWN;
  }
}
