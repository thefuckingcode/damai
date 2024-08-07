package com.uc.webview.export.internal.utility;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.internal.setup.UCSetupException;
import java.io.File;
import tb.jl1;

/* compiled from: Taobao */
public final class w {
    public static String a(String str) {
        File file = new File(str);
        return UCCyclone.getSourceHash(UCCyclone.getDecompressSourceHash(str, file.length(), file.lastModified(), false));
    }

    public static boolean a(String str, Context context) {
        File a = p.a(context, Constants.KEY_FLAGS);
        String a2 = a(str);
        Log.d("VerifyUtils", "verifyQuick archiveFilePath:" + str + ", prefix:" + a2);
        if (new File(a, a2 + "_n").exists()) {
            if (new File(a, a2 + "_y").exists()) {
                return false;
            }
            Log.d("VerifyUtils", "快速校验 Quick Failed [" + str + jl1.ARRAY_END_STR);
            throw new UCSetupException(3005, String.format("[%s] verifyQuick failed", str));
        }
        if (!new File(a, a2 + "_y").exists()) {
            return false;
        }
        Log.d("VerifyUtils", "快速校验 Quick Success [" + str + jl1.ARRAY_END_STR);
        return true;
    }

    public static void a(String str, Context context, boolean z) {
        File a = p.a(context, Constants.KEY_FLAGS);
        String a2 = a(str);
        Log.d("VerifyUtils", "setVerifyQuick archiveFilePath:" + str + ", prefix:" + a2 + ", ok:" + z);
        try {
            File file = new File(a, a2 + "_y");
            File file2 = new File(a, a2 + "_n");
            if (z) {
                file.createNewFile();
                file2.delete();
                return;
            }
            file.delete();
            file2.createNewFile();
        } catch (Exception unused) {
        }
    }
}
