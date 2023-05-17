package com.miliky.self_start_background.utils

import android.os.Build
import java.util.*

/**
 *
 *
 * @Author: Miliky
 * @Date: 2023/5/15 16:27
 * @Description: [爱意随风起，风止意难平。]
 */
object CheckPhoneModel {

    /**
     *  Get Phone Model
     *  if not find PhoneModel return null
     */
    fun getPhoneModel(): PhoneModel {
       return when(Build.BRAND.lowercase(Locale.getDefault())){
           "zte" -> PhoneModel.ZTE
           "vivo" -> PhoneModel.VIVO
           "sony" -> PhoneModel.SONY
           "meizu" -> PhoneModel.MEIZU
           "lenovo" -> PhoneModel.LENOVO
           "samsung" -> PhoneModel.SAMSUNG
           "coolpad" -> PhoneModel.COOLPAD
           "huawei", "honor" -> PhoneModel.HUAWEI
           "xiaomi", "redmi", "mi" -> PhoneModel.XIAOMI
           "oppo", "oneplus", "realme" -> PhoneModel.OPPO
           else -> PhoneModel.UNKNOWN
       }
    }

}