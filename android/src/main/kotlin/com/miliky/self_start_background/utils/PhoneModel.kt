package com.miliky.self_start_background.utils

import android.os.Build
import java.util.*

/**
 *
 *
 * @Author: Miliky
 * @Date: 2023/5/15 14:51
 * @Description: [爱意随风起，风止意难平。]
 */
enum class PhoneModel {
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


    fun toStrValue(): String{
       return when(this) {
          ZTE -> "zte"
          VIVO -> "vivo"
          SONY -> "sony"
          OPPO -> "oppo"
          MEIZU -> "meizu"
          HUAWEI -> "huawei"
          XIAOMI -> "xiaomi"
          LENOVO -> "lenovo"
          SAMSUNG -> "samsung"
          COOLPAD -> "coolpad"
          else -> Build.BRAND.lowercase(Locale.getDefault())
       }
    }

}