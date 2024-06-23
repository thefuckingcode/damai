package com.alipay.camera2.operation;

import android.text.TextUtils;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.camera2.util.Camera2Utils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.util.ScanDeviceProperty;
import org.json.JSONObject;

/* compiled from: Taobao */
public class Camera2FocusParameterConfig {
    private static JSONObject d = null;
    private static boolean e = false;
    private static String f = "c-picture";
    private static String g = "auto";
    private int a = 0;
    private int b = 0;
    private long c;

    public Camera2FocusParameterConfig(Camera2CharacteristicsCache camera2CharacteristicsCache) {
        boolean hasFocuser = camera2CharacteristicsCache.hasFocuser();
        this.a = b(camera2CharacteristicsCache);
        if (e) {
            MPaasLogger.d("Camera2FocusParameterConfig", new Object[]{"camera2 switch to auto mode"});
            this.a = a(camera2CharacteristicsCache);
            WalletBury.addWalletBury("recordForceSwitchToAutoFocusMode", new Class[]{Boolean.TYPE, String.class}, new Object[]{Boolean.TRUE, String.valueOf(ScanDeviceProperty.getRomVersion())});
        }
        if (hasFocuser && !initFocusModeIsAuto()) {
            this.b = a(camera2CharacteristicsCache);
        }
        this.c = 500;
    }

    private int a(Camera2CharacteristicsCache camera2CharacteristicsCache) {
        if (camera2CharacteristicsCache == null) {
            return 0;
        }
        int[] availableAfModes = camera2CharacteristicsCache.getAvailableAfModes();
        if (g.equalsIgnoreCase("auto") && Camera2Utils.contains(availableAfModes, 1)) {
            return 1;
        }
        if (!g.equalsIgnoreCase(BQCCameraParam.FOCUS_TYPE_MACRO) || !Camera2Utils.contains(availableAfModes, 2)) {
            return 0;
        }
        return 2;
    }

    private int b(Camera2CharacteristicsCache camera2CharacteristicsCache) {
        if (camera2CharacteristicsCache == null) {
            return 0;
        }
        int[] availableAfModes = camera2CharacteristicsCache.getAvailableAfModes();
        if (f.equalsIgnoreCase("c-picture") && Camera2Utils.contains(availableAfModes, 4)) {
            return 4;
        }
        if (!f.equalsIgnoreCase("c-video") || !Camera2Utils.contains(availableAfModes, 3)) {
            return 0;
        }
        return 3;
    }

    public static JSONObject getInitFocusDistanceJSON() {
        return d;
    }

    public static void setPreferredAutoFocusMode(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (BQCCameraParam.FOCUS_TYPE_MACRO.equalsIgnoreCase(str.toLowerCase()) || "auto".equalsIgnoreCase(str.toLowerCase())) {
                g = str;
            }
        }
    }

    public static void setPreferredContinuousFocusMode(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("c-picture".equalsIgnoreCase(str.toLowerCase()) || "c-video".equalsIgnoreCase(str.toLowerCase())) {
                f = str;
            }
        }
    }

    public static void updateEnableInitFocusToAutoValue(String str) {
        if (!TextUtils.isEmpty(str)) {
            e = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
        }
    }

    public static void updateInitFocusDistance(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                d = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }
    }

    public long getDelayDuration() {
        return this.c;
    }

    public float getHistoryAvgFocusDistance() {
        JSONObject jSONObject = d;
        if (jSONObject == null) {
            return -1.0f;
        }
        try {
            if (jSONObject.has(BQCCameraParam.KEY_CAMERA2_FOCUS_DISTANCE_AVG_VALUE)) {
                return Float.parseFloat(d.getString(BQCCameraParam.KEY_CAMERA2_FOCUS_DISTANCE_AVG_VALUE));
            }
        } catch (Throwable unused) {
        }
        return -1.0f;
    }

    public long getHistorySuccessfulFocusDistanceCount() {
        JSONObject jSONObject = d;
        if (jSONObject == null) {
            return -1;
        }
        try {
            if (jSONObject.has(BQCCameraParam.KEY_CAMERA2_FOCUS_DISTANCE_TOTAL_COUNT)) {
                return Long.parseLong(d.getString(BQCCameraParam.KEY_CAMERA2_FOCUS_DISTANCE_TOTAL_COUNT));
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public int getInitFocusMode() {
        return this.a;
    }

    public int getSecondFocusMode() {
        return this.b;
    }

    public boolean initFocusModeIsAuto() {
        int i = this.a;
        return i == 2 || i == 1;
    }

    public boolean secondFocusModeIsAuto() {
        int i = this.b;
        return i == 2 || i == 1;
    }

    public void setDelayDuration(long j) {
        this.c = j;
    }

    public void setInitFocusMode(int i) {
        this.a = i;
    }

    public void setSecondFocusMode(int i) {
        this.b = i;
    }
}
