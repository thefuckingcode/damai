package com.youku.live.dago.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class DataUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int getListSize(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150665202")) {
            return ((Integer) ipChange.ipc$dispatch("-150665202", new Object[]{list})).intValue();
        } else if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    public static long getLongNumberFromString(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2037236135")) {
            return getLongNumberFromString(str, 0);
        }
        return ((Long) ipChange.ipc$dispatch("2037236135", new Object[]{str})).longValue();
    }

    public static boolean isNullOrEmpty(@Nullable List<?> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1444063291")) {
            return list == null || list.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1444063291", new Object[]{list})).booleanValue();
    }

    public static long getLongNumberFromString(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1270158491")) {
            return ((Long) ipChange.ipc$dispatch("-1270158491", new Object[]{str, Long.valueOf(j)})).longValue();
        } else if (TextUtils.isEmpty(str)) {
            return j;
        } else {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return j;
            }
        }
    }
}
