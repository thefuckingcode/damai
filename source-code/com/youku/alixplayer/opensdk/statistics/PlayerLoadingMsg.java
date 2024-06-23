package com.youku.alixplayer.opensdk.statistics;

import android.text.TextUtils;

/* compiled from: Taobao */
public class PlayerLoadingMsg {
    public String avgBitRate = "";
    public String avgNetSpeed = "";
    public String cdnIP = "";
    public String impairmentPoint = "";
    public String loadingState = "";
    public String netSpeed = "";
    public String playUrl = "";
    public String rangeDuration = "";

    private double formateDouble(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.valueOf(str).doubleValue();
            }
            return 0.0d;
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    public static String getFileId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                String[] split2 = split[0].split("/");
                if (split2.length > 0) {
                    return split2[split2.length - 1].split("\\.")[0];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public double getAvgBitRate() {
        return formateDouble(this.avgBitRate);
    }

    public double getAvgNetSpeed() {
        return formateDouble(this.avgNetSpeed);
    }

    public double getImpairmentPoint() {
        return formateDouble(this.impairmentPoint);
    }

    public double getNetSpped() {
        return formateDouble(this.netSpeed);
    }

    public double getRangeDuration() {
        return formateDouble(this.rangeDuration);
    }
}
