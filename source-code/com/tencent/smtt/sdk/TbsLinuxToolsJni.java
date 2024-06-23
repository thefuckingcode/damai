package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* access modifiers changed from: package-private */
public class TbsLinuxToolsJni {
    private static boolean a = false;
    private static boolean b = false;

    private native int ChmodInner(String str, String str2);

    public int a(String str, String str2) {
        if (a) {
            return ChmodInner(str, str2);
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }

    public TbsLinuxToolsJni(Context context) {
        a(context);
    }

    private void a(Context context) {
        File file;
        synchronized (TbsLinuxToolsJni.class) {
            TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + b);
            if (!b) {
                b = true;
                try {
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        String a2 = TbsShareManager.a();
                        if (a2 == null) {
                            a2 = TbsShareManager.c(context);
                        }
                        file = new File(a2);
                    } else {
                        file = m.a().q(context);
                    }
                    if (file != null) {
                        if (!new File(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() && !TbsShareManager.isThirdPartyApp(context)) {
                            file = m.a().p(context);
                        }
                        if (file != null) {
                            TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + file.getAbsolutePath());
                            System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                            a = true;
                        }
                    }
                    ChmodInner("/checkChmodeExists", "700");
                } catch (Throwable th) {
                    th.printStackTrace();
                    a = false;
                    TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init error !!! " + th.getMessage() + " ## " + th.getCause());
                }
            }
        }
    }
}
