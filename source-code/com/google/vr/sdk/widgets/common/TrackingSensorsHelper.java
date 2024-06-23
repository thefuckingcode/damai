package com.google.vr.sdk.widgets.common;

import android.content.pm.PackageManager;

/* compiled from: Taobao */
public class TrackingSensorsHelper {
    public static boolean enableTouchTracking;
    public static boolean pretendSensorsAreAvailableForTesting;
    public static boolean showStereoModeButtonForTesting;
    PackageManager packageManager;

    public TrackingSensorsHelper(PackageManager packageManager2) {
        this.packageManager = packageManager2;
    }

    public boolean areTrackingSensorsAvailable() {
        if (pretendSensorsAreAvailableForTesting) {
            return true;
        }
        if (!enableTouchTracking && this.packageManager.hasSystemFeature("android.hardware.sensor.gyroscope") && this.packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
            return true;
        }
        return false;
    }

    public boolean showStereoModeButtonForTesting() {
        return showStereoModeButtonForTesting;
    }
}
