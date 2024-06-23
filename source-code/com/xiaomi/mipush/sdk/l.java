package com.xiaomi.mipush.sdk;

import com.xiaomi.push.ho;
import java.util.HashMap;

/* compiled from: Taobao */
public class l {
    private static HashMap<e, a> a = new HashMap<>();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(e.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static au a(e eVar) {
        int i = m.a[eVar.ordinal()];
        if (i == 1) {
            return au.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return au.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return au.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return au.UPLOAD_FTOS_TOKEN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m244a(e eVar) {
        return a.get(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ho m245a(e eVar) {
        return ho.AggregatePushSwitch;
    }

    private static void a(e eVar, a aVar) {
        if (aVar != null) {
            a.put(eVar, aVar);
        }
    }
}
