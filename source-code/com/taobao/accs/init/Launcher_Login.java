package com.taobao.accs.init;

import android.app.Application;
import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public class Launcher_Login implements Serializable {
    public void init(final Application application, final HashMap<String, Object> hashMap) {
        ALog.i("Launcher_Login", "login", new Object[0]);
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.accs.init.Launcher_Login.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:27:0x0057 A[Catch:{ all -> 0x0094 }] */
            public void run() {
                String str;
                Throwable th;
                String str2;
                try {
                    int intValue = ((Integer) hashMap.get("envIndex")).intValue();
                    str = (String) hashMap.get("onlineAppKey");
                    if (intValue == 1) {
                        try {
                            str2 = (String) hashMap.get("preAppKey");
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                ALog.e("Launcher_Login", "login get param error", th, new Object[0]);
                                if (TextUtils.isEmpty(str)) {
                                }
                                Launcher_InitAccs.mContext = application;
                                Launcher_InitAccs.mAppkey = str;
                                Launcher_InitAccs.mForceBindUser = true;
                                Launcher_InitAccs.mUserId = (String) hashMap.get("userId");
                                Launcher_InitAccs.mSid = (String) hashMap.get("sid");
                                ACCSClient.getAccsClient().bindApp((String) hashMap.get("ttid"), Launcher_InitAccs.mAppReceiver);
                            } catch (Throwable th3) {
                                ALog.e("Launcher_Login", "login", th3, new Object[0]);
                                return;
                            }
                        }
                    } else {
                        if ((intValue == 2) || (intValue == 3)) {
                            str2 = (String) hashMap.get("dailyAppkey");
                        }
                        if (TextUtils.isEmpty(str)) {
                            ALog.e("Launcher_Login", "login get appkey null", new Object[0]);
                            str = "21646297";
                        }
                        Launcher_InitAccs.mContext = application;
                        Launcher_InitAccs.mAppkey = str;
                        Launcher_InitAccs.mForceBindUser = true;
                        Launcher_InitAccs.mUserId = (String) hashMap.get("userId");
                        Launcher_InitAccs.mSid = (String) hashMap.get("sid");
                        ACCSClient.getAccsClient().bindApp((String) hashMap.get("ttid"), Launcher_InitAccs.mAppReceiver);
                    }
                    str = str2;
                } catch (Throwable th4) {
                    str = null;
                    th = th4;
                    ALog.e("Launcher_Login", "login get param error", th, new Object[0]);
                    if (TextUtils.isEmpty(str)) {
                    }
                    Launcher_InitAccs.mContext = application;
                    Launcher_InitAccs.mAppkey = str;
                    Launcher_InitAccs.mForceBindUser = true;
                    Launcher_InitAccs.mUserId = (String) hashMap.get("userId");
                    Launcher_InitAccs.mSid = (String) hashMap.get("sid");
                    ACCSClient.getAccsClient().bindApp((String) hashMap.get("ttid"), Launcher_InitAccs.mAppReceiver);
                }
                if (TextUtils.isEmpty(str)) {
                }
                Launcher_InitAccs.mContext = application;
                Launcher_InitAccs.mAppkey = str;
                Launcher_InitAccs.mForceBindUser = true;
                Launcher_InitAccs.mUserId = (String) hashMap.get("userId");
                Launcher_InitAccs.mSid = (String) hashMap.get("sid");
                ACCSClient.getAccsClient().bindApp((String) hashMap.get("ttid"), Launcher_InitAccs.mAppReceiver);
            }
        });
    }
}
