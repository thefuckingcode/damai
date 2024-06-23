package com.alipay.sdk.app;

/* compiled from: Taobao */
public class EnvUtils {
    public static EnvEnum mEnv = EnvEnum.ONLINE;

    /* compiled from: Taobao */
    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    public static EnvEnum geEnv() {
        return mEnv;
    }

    public static boolean isSandBox() {
        return mEnv == EnvEnum.SANDBOX;
    }

    public static void setEnv(EnvEnum envEnum) {
        mEnv = envEnum;
    }
}
