package com.taobao.android.dinamicx;

import tb.at;
import tb.jx;

/* compiled from: Taobao */
public class c {
    static IDXElderInterface a;
    static jx b;

    public static float a(float f) {
        return f() ? c(f) : f;
    }

    public static float b(DXRuntimeContext dXRuntimeContext, float f) {
        return f() ? d(dXRuntimeContext, f) : f;
    }

    public static float c(float f) {
        jx jxVar = b;
        if (jxVar == null) {
            return f;
        }
        return jxVar.a(Float.valueOf(f)).floatValue();
    }

    public static float d(DXRuntimeContext dXRuntimeContext, float f) {
        jx e = e(dXRuntimeContext.config);
        if (e == null) {
            return f;
        }
        return e.a(Float.valueOf(f)).floatValue();
    }

    private static jx e(DXEngineConfig dXEngineConfig) {
        if (dXEngineConfig == null) {
            return null;
        }
        return dXEngineConfig.d();
    }

    public static boolean f() {
        IDXElderInterface iDXElderInterface = a;
        if (iDXElderInterface == null) {
            return false;
        }
        return iDXElderInterface.isElder();
    }

    public static boolean g(String str) {
        return at.m0(str);
    }
}
