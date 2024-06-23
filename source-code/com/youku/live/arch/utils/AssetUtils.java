package com.youku.live.arch.utils;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class AssetUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A[SYNTHETIC, Splitter:B:19:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    public static String readContent(Context context, String str) {
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1411514249")) {
            return (String) ipChange.ipc$dispatch("-1411514249", new Object[]{context, str});
        }
        BufferedReader bufferedReader = null;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    return sb.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
        } catch (IOException unused3) {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return sb.toString();
    }
}
