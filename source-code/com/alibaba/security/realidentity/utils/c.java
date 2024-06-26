package com.alibaba.security.realidentity.utils;

import android.app.Activity;
import cn.wh.auth.OnCallBack;
import com.alibaba.fastjson.JSONException;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a;
import com.alibaba.security.realidentity.business.dynamic.model.CtidConfig;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import tb.ax2;
import tb.j12;
import tb.zw2;

/* compiled from: Taobao */
public class c {
    private static final String c = "c";
    public int a;
    public String b;

    public static boolean a() {
        return true;
    }

    private int c() {
        return this.a;
    }

    private String d() {
        return this.b;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int b(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case 1874685069:
                if (str.equals(a.q)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1989201674:
                if (str.equals(a.x)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231465:
                if (str.equals(a.C)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231467:
                if (str.equals(a.D)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231468:
                if (str.equals(a.E)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231473:
                if (str.equals(a.z)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231495:
                if (str.equals(a.A)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1989261256:
                if (str.equals(a.B)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1989350629:
                if (str.equals(a.y)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184778:
                if (str.equals(a.r)) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184779:
                if (str.equals(a.s)) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184780:
                if (str.equals(a.t)) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184781:
                if (str.equals(a.u)) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184782:
                if (str.equals(a.v)) {
                    c2 = CharUtils.CR;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184783:
                if (str.equals(a.w)) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return 0;
            case 1:
                return GlobalErrorCode.ERROR_CTID_APP_ERROR;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 4001;
            case '\b':
                return GlobalErrorCode.ERROR_CTID_DATA_ERROR;
            case '\t':
                return 4002;
            case '\n':
            default:
                return -1;
            case 11:
                return 4003;
            case '\f':
                return 4004;
            case '\r':
                return GlobalErrorCode.ERROR_CTID_NO_CERT;
            case 14:
                return GlobalErrorCode.ERROR_CTID_NOT_BINDING;
        }
    }

    private void a(CtidConfig ctidConfig, Activity activity, final String str, final Runnable runnable) {
        ax2 ax2 = new ax2(ctidConfig.getOrgId(), ctidConfig.getAndroidAppId(), str, ctidConfig.getType());
        a(ctidConfig, str);
        new zw2(activity, ax2).getAuthResult(new OnCallBack() {
            /* class com.alibaba.security.realidentity.utils.c.AnonymousClass1 */

            @Override // cn.wh.auth.OnCallBack
            public final void onResult(j12 j12) {
                String str = c.c;
                com.alibaba.security.common.c.a.a(str, "CTID result: " + j12.a() + ", resultDesc: " + j12.c());
                c.a(j12, str);
                c.this.a = c.a(j12.a());
                c.this.b = j12.b().b();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    private static void b(j12 j12, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("resultCode", j12.a());
        hashMap.put("idAuthData", j12.b().b());
        hashMap.put("resultMsg", j12.c());
        a(str, TrackLog.createCtidAppEndLog(h.a((Map) hashMap)));
    }

    public static void a(CtidConfig ctidConfig, String str) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("orgId", ctidConfig.getOrgId());
            hashMap.put(ALBiometricsKeys.KEY_APP_ID, ctidConfig.getAndroidAppId());
            hashMap.put("bizSeq", str);
            hashMap.put("type", String.valueOf(ctidConfig.getType()));
        } catch (JSONException unused) {
            com.alibaba.security.common.c.a.b();
        }
        a(str, TrackLog.createCtidAppStartLog(h.a((Map) hashMap)));
    }

    private static void a(String str, TrackLog trackLog) {
        trackLog.setVerifyToken(str);
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        a.C0102a.a.a(trackLog);
    }

    static /* synthetic */ void a(j12 j12, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("resultCode", j12.a());
        hashMap.put("idAuthData", j12.b().b());
        hashMap.put("resultMsg", j12.c());
        a(str, TrackLog.createCtidAppEndLog(h.a((Map) hashMap)));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ int a(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case 1874685069:
                if (str.equals(com.alibaba.security.realidentity.a.q)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1989201674:
                if (str.equals(com.alibaba.security.realidentity.a.x)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231465:
                if (str.equals(com.alibaba.security.realidentity.a.C)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231467:
                if (str.equals(com.alibaba.security.realidentity.a.D)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231468:
                if (str.equals(com.alibaba.security.realidentity.a.E)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231473:
                if (str.equals(com.alibaba.security.realidentity.a.z)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231495:
                if (str.equals(com.alibaba.security.realidentity.a.A)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1989261256:
                if (str.equals(com.alibaba.security.realidentity.a.B)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1989350629:
                if (str.equals(com.alibaba.security.realidentity.a.y)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184778:
                if (str.equals(com.alibaba.security.realidentity.a.r)) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184779:
                if (str.equals(com.alibaba.security.realidentity.a.s)) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184780:
                if (str.equals(com.alibaba.security.realidentity.a.t)) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184781:
                if (str.equals(com.alibaba.security.realidentity.a.u)) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184782:
                if (str.equals(com.alibaba.security.realidentity.a.v)) {
                    c2 = CharUtils.CR;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184783:
                if (str.equals(com.alibaba.security.realidentity.a.w)) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return 0;
            case 1:
                return GlobalErrorCode.ERROR_CTID_APP_ERROR;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 4001;
            case '\b':
                return GlobalErrorCode.ERROR_CTID_DATA_ERROR;
            case '\t':
                return 4002;
            case '\n':
            default:
                return -1;
            case 11:
                return 4003;
            case '\f':
                return 4004;
            case '\r':
                return GlobalErrorCode.ERROR_CTID_NO_CERT;
            case 14:
                return GlobalErrorCode.ERROR_CTID_NOT_BINDING;
        }
    }
}
