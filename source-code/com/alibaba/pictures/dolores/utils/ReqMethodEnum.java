package com.alibaba.pictures.dolores.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/dolores/utils/ReqMethodEnum;", "", "", "methodName", "Ljava/lang/String;", "getMethodName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GET", "POST", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public enum ReqMethodEnum {
    GET("GET"),
    POST("POST");
    
    @NotNull
    private final String methodName;

    private ReqMethodEnum(String str) {
        this.methodName = str;
    }

    @NotNull
    public final String getMethodName() {
        return this.methodName;
    }
}
