package com.youku.android.utils;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.tlog.adapter.AdapterForTLog;

@Keep
/* compiled from: Taobao */
public class OprLogUtils {
    public static final String LOG_PREFIX = "OPR_v2_";

    public static void TLogPrint(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            AdapterForTLog.logi(LOG_PREFIX + str, "TLogPrint: " + str2);
        }
    }
}
