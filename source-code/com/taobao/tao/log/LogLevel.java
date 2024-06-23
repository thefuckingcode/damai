package com.taobao.tao.log;

import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;

/* compiled from: Taobao */
public enum LogLevel {
    ALL("ALL", 0),
    V("V", 0),
    D("D", 1),
    I("I", 2),
    W(ExifInterface.LONGITUDE_WEST, 3),
    E(ExifInterface.LONGITUDE_EAST, 4),
    F(UTConstant.Args.UT_SUCCESS_F, 5),
    N("N", 6),
    L("L", 6);
    
    private int index;
    private String name;

    private LogLevel(String str, int i) {
        this.name = str;
        this.index = i;
    }

    /* access modifiers changed from: protected */
    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    protected static String getName(int i) {
        LogLevel[] values = values();
        for (LogLevel logLevel : values) {
            if (logLevel.getIndex() == i) {
                return logLevel.name;
            }
        }
        return null;
    }
}
