package com.youku.playerservice.axp.utils;

import tb.jl1;

/* compiled from: Taobao */
public class SessionUtil {
    private static int sIndex;

    public static String create(String str) {
        String str2 = str + jl1.PLUS + sIndex + jl1.PLUS + System.currentTimeMillis();
        sIndex++;
        return str2;
    }
}
