package com.youku.vpm.utils;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
public class StaticsUtil {

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.vpm.utils.StaticsUtil$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[NetworkStatusHelper.NetworkStatus.values().length];
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus = iArr;
            iArr[NetworkStatusHelper.NetworkStatus.NONE.ordinal()] = 1;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.NO.ordinal()] = 2;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G2.ordinal()] = 3;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G3.ordinal()] = 4;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G4.ordinal()] = 5;
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.WIFI.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String getNetStatus() {
        switch (AnonymousClass1.$SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.i().ordinal()]) {
            case 1:
            default:
                return "NONE";
            case 2:
                return "noNetwork";
            case 3:
                return "2G";
            case 4:
                return "3G";
            case 5:
                return "4G";
            case 6:
                return "WiFi";
        }
    }

    public static boolean hasInternet() {
        return !"noNetwork".equals(getNetStatus());
    }
}
