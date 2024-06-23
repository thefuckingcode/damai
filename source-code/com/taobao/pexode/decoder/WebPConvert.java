package com.taobao.pexode.decoder;

import androidx.annotation.Keep;
import com.taobao.pexode.Pexode;
import tb.kg0;

@Keep
/* compiled from: Taobao */
public class WebPConvert {
    public static boolean sIsSoInstalled = true;

    static {
        try {
            System.loadLibrary("dwebp");
            kg0.f(Pexode.TAG, "system load lib%s.so result=%b", "WebPConvert", true);
        } catch (UnsatisfiedLinkError e) {
            kg0.c(Pexode.TAG, "system load lib%s.so error=%s", "WebPConvert", e);
        }
    }

    public static native int nativeProcess(byte[] bArr, String str);

    public static native void nativeUseBugFix(boolean z);
}
