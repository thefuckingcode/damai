package com.youku.android.utils;

import java.util.List;

/* compiled from: Taobao */
public class CalculateUtils {
    public static Double calculateAverage(List<Long> list) {
        Double valueOf = Double.valueOf(0.0d);
        if (list.isEmpty()) {
            return valueOf;
        }
        for (Long l : list) {
            valueOf = Double.valueOf(valueOf.doubleValue() + ((double) l.longValue()));
        }
        return Double.valueOf(valueOf.doubleValue() / ((double) list.size()));
    }
}
