package com.taobao.analysis;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface StageType {
    public static final String PARSE = "parse";
    public static final String PROCESS = "process";
    public static final String RENDER = "render";

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Definition {
    }
}
