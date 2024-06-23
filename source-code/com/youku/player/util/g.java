package com.youku.player.util;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.middlewareservice.provider.support.FunctionSupportProviderProxy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: Taobao */
public class g {
    public static long a() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static long b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            for (String str : split) {
                Log.i(readLine, str + "\t");
            }
            long intValue = (long) Integer.valueOf(split[1]).intValue();
            bufferedReader.close();
            return intValue;
        } catch (IOException unused) {
            return 0;
        }
    }

    public static boolean c() {
        if (!FunctionSupportProviderProxy.isSupported("OLD_PLAYER")) {
            return true;
        }
        String config = ConfigFetcher.getInstance().getConfig("laifenglive_alixplayer", "live_nativeplayer_openalix", "0");
        return !TextUtils.isEmpty(config) && "1".equals(config);
    }
}
