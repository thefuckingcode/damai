package com.taobao.login4android.video;

import java.text.SimpleDateFormat;

/* compiled from: Taobao */
public class TimeUtil {
    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(Long.valueOf(System.currentTimeMillis()));
    }
}
