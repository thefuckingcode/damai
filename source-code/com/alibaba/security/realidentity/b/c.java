package com.alibaba.security.realidentity.b;

import android.hardware.Camera;
import com.alibaba.security.common.c.a;

/* compiled from: Taobao */
public final class c {
    public static final int a = -1;
    private static final String b = "com.alibaba.security.realidentity.b.c";

    private c() {
    }

    public static Camera a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            a.e(b, "No cameras!");
            return null;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            a.b(b, "Opening camera #".concat(String.valueOf(i)));
            return Camera.open(i);
        } else if (z) {
            a.e(b, "Requested camera does not exist: ".concat(String.valueOf(i)));
            return null;
        } else {
            a.b(b, "No camera facing back; returning camera #0");
            return Camera.open(0);
        }
    }
}
