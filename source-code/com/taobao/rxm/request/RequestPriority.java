package com.taobao.rxm.request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* compiled from: Taobao */
public @interface RequestPriority {
    public static final int EXTREME_HIGH = 4;
    public static final int HIGH = 3;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
}
