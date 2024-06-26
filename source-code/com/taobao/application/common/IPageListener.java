package com.taobao.application.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
public interface IPageListener {
    public static final int DRAW_START = 1;
    public static final int INIT_TIME = 0;
    public static final int INTERACTIVE = 3;
    public static final int SKI_INTERACTIVE = 4;
    public static final int VISIBLE = 2;

    @Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface PageStatus {
    }

    void onPageChanged(String str, int i, long j);
}
