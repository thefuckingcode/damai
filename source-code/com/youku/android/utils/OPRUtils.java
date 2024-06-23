package com.youku.android.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.taomai.android.h5container.api.TaoMaiFilePlugin;
import com.youku.android.barrage.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import org.apache.commons.lang3.StringUtils;
import tb.o70;

@Keep
/* compiled from: Taobao */
public class OPRUtils {
    private static final String TAG = "OPR_v2_OPRUtils";
    private static Context mContext;

    /* compiled from: Taobao */
    public interface OPRPhoneLevel {
        public static final String OPR_PHONE_LEVEL_HIGH = "1001";
        public static final String OPR_PHONE_LEVEL_LOW = "1003";
        public static final String OPR_PHONE_LEVEL_MEDIUM = "1002";
        public static final String OPR_PHONE_LEVEL_UNKNOWN = "0";
    }

    public static String getApsConfig(String str, String str2, String str3) {
        return ApsConfigUtils.getInstance().getConfig(str, str2, str3);
    }

    public static String getCurrentPhoneLevel() {
        long totalMemory = getTotalMemory();
        int i = (totalMemory > 4194304 ? 1 : (totalMemory == 4194304 ? 0 : -1));
        String str = (i <= 0 || Build.VERSION.SDK_INT <= 24) ? OPRPhoneLevel.OPR_PHONE_LEVEL_LOW : (i <= 0 || totalMemory > TaoMaiFilePlugin.FILE_MAX_SIZE) ? "1001" : OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM;
        Log.d(TAG, "getCurrentPhoneLevel: " + str + ", totalMem: " + totalMemory);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    public static String getShader(String str) {
        Context context;
        String str2;
        IOException e;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || (context = mContext) == null) {
            Log.e(TAG, "key is null or mContext is null");
            return "";
        }
        InputStream openRawResource = context.getResources().openRawResource(R.raw.shaders);
        String str3 = null;
        try {
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            str2 = new String(bArr, "utf-8");
            try {
                openRawResource.close();
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            str2 = null;
            e.printStackTrace();
            if (TextUtils.isEmpty(str2)) {
            }
            return sb.toString();
        }
        if (TextUtils.isEmpty(str2)) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(EncryptUtils.base64Decrypt(str2)));
            boolean z = false;
            boolean z2 = false;
            do {
                try {
                    str3 = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.equals(o70.DINAMIC_PREFIX_AT + str + " START")) {
                            z = true;
                        } else if (z) {
                            z2 = true;
                        }
                        if (str3.equals(o70.DINAMIC_PREFIX_AT + str + " END")) {
                            z = false;
                        }
                        if (z && z2) {
                            sb.append(str3 + StringUtils.LF);
                            continue;
                        }
                    } else {
                        continue;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    continue;
                } catch (Throwable th) {
                    th.printStackTrace();
                    continue;
                }
            } while (str3 != null);
        }
        return sb.toString();
    }

    public static long getTotalMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) mContext.getSystemService("activity")).getMemoryInfo(memoryInfo);
        Log.d(TAG, "getTotalMemory totalMem: " + memoryInfo.totalMem);
        return memoryInfo.totalMem;
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
