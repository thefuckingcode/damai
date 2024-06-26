package com.taobao.phenix.cache.disk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* compiled from: Taobao */
public @interface DiskCachePriority {
    public static final int TOP_USED_1 = 17;
    public static final int TOP_USED_2 = 34;
    public static final int TOP_USED_3 = 51;
    public static final int TOP_USED_4 = 68;
    public static final int TOP_USED_5 = 85;
}
