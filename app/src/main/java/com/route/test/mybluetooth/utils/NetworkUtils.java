package com.route.test.mybluetooth.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by chj on 2017/8/30.
 */

public class NetworkUtils {
    public static String type="";
    public static String getCurrentNetTuype(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=cm.getActiveNetworkInfo();
        if (info == null) {
            type="null";
        }else if (info.getType()==ConnectivityManager.TYPE_WIFI){
            type="wifi";
        }else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            int subType=info.getSubtype();
            if (subType == TelephonyManager.NETWORK_TYPE_CDMA
                    || subType == TelephonyManager.NETWORK_TYPE_GPRS
                    || subType == TelephonyManager.NETWORK_TYPE_EDGE) {
                type="2g";

            }else if (subType == TelephonyManager.NETWORK_TYPE_UMTS
                    || subType == TelephonyManager.NETWORK_TYPE_HSDPA
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_A
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_0
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_B) {
                type="3g";

            }else if (subType == TelephonyManager.NETWORK_TYPE_LTE){//LTE是3g到4G的过度,是3.9G的全球标准
                type="4g";
            }

        }
        return type;

    }
    public static boolean networkIsAvailable(Context context){
        if (getCurrentNetTuype(context).equals(null)) {
            return false;
        }else{
            return true;
        }
    }
}