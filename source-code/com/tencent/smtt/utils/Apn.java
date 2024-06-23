package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.core.os.EnvironmentCompat;

public class Apn {
    public static final int APN_2G = 1;
    public static final int APN_3G = 2;
    public static final int APN_4G = 4;
    public static final int APN_UNKNOWN = 0;
    public static final int APN_WIFI = 3;

    public static String getApnInfo(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                str = activeNetworkInfo.getExtraInfo();
            } else if (type != 1) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            } else {
                str = "wifi";
            }
            return str;
        } catch (Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:786)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:130)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:701)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:696)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:50)
        */
    public static int getApnType(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x002d
            boolean r2 = r3.isConnectedOrConnecting()
            if (r2 == 0) goto L_0x002d
            int r2 = r3.getType()
            if (r2 == 0) goto L_0x0021
            if (r2 == r0) goto L_0x001f
            goto L_0x002d
        L_0x001f:
            r0 = 3
            goto L_0x002e
        L_0x0021:
            int r3 = r3.getSubtype()
            switch(r3) {
                case 1: goto L_0x002e;
                case 2: goto L_0x002e;
                case 3: goto L_0x002b;
                case 4: goto L_0x002e;
                case 5: goto L_0x002b;
                case 6: goto L_0x002b;
                case 7: goto L_0x002e;
                case 8: goto L_0x002b;
                case 9: goto L_0x002b;
                case 10: goto L_0x002b;
                case 11: goto L_0x002e;
                case 12: goto L_0x002b;
                case 13: goto L_0x0029;
                case 14: goto L_0x002b;
                case 15: goto L_0x002b;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x002d
        L_0x0029:
            r0 = 4
            goto L_0x002e
        L_0x002b:
            r0 = 2
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            return r0
            switch-data {1->0x002e, 2->0x002e, 3->0x002b, 4->0x002e, 5->0x002b, 6->0x002b, 7->0x002e, 8->0x002b, 9->0x002b, 10->0x002b, 11->0x002e, 12->0x002b, 13->0x0029, 14->0x002b, 15->0x002b, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Apn.getApnType(android.content.Context):int");
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.isConnected() || activeNetworkInfo.isAvailable()) {
            return true;
        }
        return false;
    }

    public static String getWifiSSID(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getBSSID();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
