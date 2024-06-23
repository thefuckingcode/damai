package com.youku.uplayer;

import android.text.TextUtils;
import com.youku.player.util.c;

/* compiled from: Taobao */
public class PlayerLoadingEndMsg {
    public String cpuTakeUP = "";
    public String networkBPS = "";
    public String storageAvailability = "";

    public static PlayerLoadingEndMsg creat(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(";");
            if (split.length >= 3) {
                PlayerLoadingEndMsg playerLoadingEndMsg = new PlayerLoadingEndMsg();
                try {
                    playerLoadingEndMsg.cpuTakeUP = split[0];
                    playerLoadingEndMsg.networkBPS = split[1];
                    playerLoadingEndMsg.storageAvailability = split[2];
                } catch (Exception unused) {
                }
                return playerLoadingEndMsg;
            }
            String str2 = LogTag.TAG_PLAYER;
            c.a(str2, "PlayerLoadingEndMsg ---> " + str);
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

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

    public double getCpuTakeUP() {
        return formateDouble(this.cpuTakeUP);
    }

    public double getNetworkBPS() {
        return formateDouble(this.networkBPS);
    }

    public double getStorageAvailability() {
        return formateDouble(this.storageAvailability);
    }
}
