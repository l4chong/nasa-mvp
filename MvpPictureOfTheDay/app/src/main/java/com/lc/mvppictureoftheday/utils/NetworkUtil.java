package com.lc.mvppictureoftheday.utils;

/**
 * Created by larrychong on 2017-07-28.
 */

public class NetworkUtil {

    public static boolean isResponseCodeOK(int responseCode){
        if (responseCode == Constants.RESPONSE_CODE_OK || responseCode == Constants.RESPONSE_CODE_ACCEPTED) {
            return true;
        }else {
            return false;
        }
    }
}
