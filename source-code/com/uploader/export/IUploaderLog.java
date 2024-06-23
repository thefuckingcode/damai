package com.uploader.export;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public interface IUploaderLog {
    public static final int D = 2;
    public static final int E = 16;
    public static final int I = 4;
    public static final int V = 1;
    public static final int W = 8;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Definition {
    }

    boolean isEnabled(int i);

    int print(int i, String str, String str2, Throwable th);
}
