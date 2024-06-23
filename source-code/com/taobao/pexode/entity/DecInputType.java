package com.taobao.pexode.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* compiled from: Taobao */
public @interface DecInputType {
    public static final int BYTE_ARRAY_TYPE = 1;
    public static final int FILE_DESCRIPTOR_TYPE = 2;
    public static final int INPUT_STREAM_TYPE = 3;
}
