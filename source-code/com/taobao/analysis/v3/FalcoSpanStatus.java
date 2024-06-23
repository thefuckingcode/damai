package com.taobao.analysis.v3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface FalcoSpanStatus {
    public static final String CANCEL = "cancel";
    public static final String FAILED = "failed";
    public static final String SUCCEED = "succeed";
    public static final String UNFINISHED = "unfinished";

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Definition {
    }
}
