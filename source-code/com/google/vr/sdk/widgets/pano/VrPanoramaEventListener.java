package com.google.vr.sdk.widgets.pano;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.vr.cardboard.annotations.UsedByNative;
import com.google.vr.sdk.widgets.common.VrEventListener;

/* compiled from: Taobao */
public class VrPanoramaEventListener extends VrEventListener {
    private static final String TAG = "VrPanoramaEventListener";
    public static volatile boolean isLoadSuccessful;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    @UsedByNative
    private void onLoadErrorJni(final String str) {
        String str2 = TAG;
        int hashCode = hashCode();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20);
        sb.append(hashCode);
        sb.append(".onError ");
        sb.append(str);
        Log.e(str2, sb.toString());
        this.uiHandler.post(new Runnable() {
            /* class com.google.vr.sdk.widgets.pano.VrPanoramaEventListener.AnonymousClass2 */

            public void run() {
                VrPanoramaEventListener.this.onLoadError(str);
            }
        });
    }

    @UsedByNative
    private void onLoadSuccessJni() {
        this.uiHandler.post(new Runnable() {
            /* class com.google.vr.sdk.widgets.pano.VrPanoramaEventListener.AnonymousClass1 */

            public void run() {
                VrPanoramaEventListener.this.onLoadSuccess();
                VrPanoramaEventListener.isLoadSuccessful = true;
            }
        });
    }
}
