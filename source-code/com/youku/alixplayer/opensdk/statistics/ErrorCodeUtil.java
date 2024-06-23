package com.youku.alixplayer.opensdk.statistics;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.utils.MappingTable;

/* compiled from: Taobao */
public class ErrorCodeUtil {
    public static String getErrorMsg(int i) {
        String errorDetailMsg = MappingTable.getErrorDetailMsg(i);
        if (!TextUtils.isEmpty(errorDetailMsg)) {
            return errorDetailMsg;
        }
        return "未知:" + i;
    }

    public static boolean isNetworkError(int i, int i2) {
        return (i == 1006 || i == 1010 || i == 2004 || i == 1023 || i == 1111) && ((i2 >= 30000 && i2 < 40000) || ((i2 >= 11010 && i2 <= 11017) || i2 == 14000));
    }
}
