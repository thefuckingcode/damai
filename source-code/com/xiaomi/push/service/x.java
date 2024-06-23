package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gh;
import com.xiaomi.push.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
public class x {
    private static ArrayList<Pair<String, byte[]>> a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Map<String, byte[]> f1002a = new HashMap();

    public static void a(Context context, int i, String str) {
        Map<String, byte[]> map = f1002a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                b.m182a("notify registration error. " + str2);
                a(context, str2, f1002a.get(str2), i, str);
            }
            f1002a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, ah.a(str));
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (a) {
                arrayList = a;
                a = new ArrayList<>();
            }
            boolean a2 = w.a();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                ah.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!a2) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (gh e) {
            b.d("meet error when process pending message. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            Map<String, byte[]> map = f1002a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    b.m182a("processing pending registration request. " + str);
                    ah.a(xMPushService, str, f1002a.get(str));
                    if (z && !w.a()) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception unused) {
                        }
                    }
                }
                f1002a.clear();
            }
        } catch (gh e) {
            b.d("fail to deal with pending register request. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = f1002a;
        synchronized (map) {
            b.m182a("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (a) {
            a.add(new Pair<>(str, bArr));
            if (a.size() > 50) {
                a.remove(0);
            }
        }
    }
}
