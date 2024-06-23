package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ae;
import com.xiaomi.push.bj;
import com.xiaomi.push.et;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gp;
import com.xiaomi.push.gy;
import com.xiaomi.push.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import tb.o70;

/* compiled from: Taobao */
public class ServiceClient {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ServiceClient f822a;

    /* renamed from: a  reason: collision with other field name */
    private static String f823a;
    private static String b = (gy.a(5) + "-");

    /* renamed from: a  reason: collision with other field name */
    private Context f824a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f825a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f826a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f827a = false;

    /* renamed from: b  reason: collision with other field name */
    private Messenger f828b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f829b = false;

    private ServiceClient(Context context) {
        this.f824a = context.getApplicationContext();
        if (m747a()) {
            b.c("use miui push service");
            this.f827a = true;
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m744a());
            intent.putExtra(bk.B, this.f824a.getPackageName());
            m745a();
            return intent;
        }
        Intent intent2 = new Intent(this.f824a, XMPushService.class);
        intent2.putExtra(bk.B, this.f824a.getPackageName());
        b();
        return intent2;
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m744a() {
        try {
            return this.f824a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            if (i < map.size()) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m745a() {
        this.f824a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f824a, XMPushService.class), 2, 1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m746a(Intent intent) {
        if (this.f829b) {
            Message a2 = a(intent);
            if (this.f826a.size() >= 50) {
                this.f826a.remove(0);
            }
            this.f826a.add(a2);
            return;
        }
        if (this.f828b == null) {
            this.f824a.bindService(intent, new bu(this), 1);
            this.f829b = true;
            this.f826a.clear();
            this.f826a.add(a(intent));
        } else {
            try {
                this.f828b.send(a(intent));
            } catch (RemoteException unused) {
                this.f828b = null;
                this.f829b = false;
            }
        }
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(bk.q, str);
        intent.putExtra(bk.t, str2);
        intent.putExtra(bk.v, str3);
        intent.putExtra(bk.x, str5);
        intent.putExtra(bk.w, str4);
        intent.putExtra(bk.y, z);
        intent.putExtra(bk.F, f823a);
        intent.putExtra(bk.J, this.f825a);
        if (map != null && map.size() > 0) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(bk.z, a2);
            }
        }
        if (map2 != null && map2.size() > 0) {
            String a3 = a(map2);
            if (!TextUtils.isEmpty(a3)) {
                intent.putExtra(bk.A, a3);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m747a() {
        if (ae.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f824a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b() {
        this.f824a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f824a, XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f822a == null) {
            f822a = new ServiceClient(context);
        }
        return f822a;
    }

    public static String getSession() {
        return f823a;
    }

    public static void setSession(String str) {
        f823a = str;
    }

    public boolean batchSendMessage(gm[] gmVarArr, boolean z) {
        if (!bj.b(this.f824a)) {
            return false;
        }
        Intent a2 = a();
        int length = gmVarArr.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < gmVarArr.length; i++) {
            String a3 = et.a();
            if (!TextUtils.isEmpty(a3)) {
                gk gkVar = new gk(Constants.PARAM_PLATFORM_ID, null, null, null);
                gk gkVar2 = new gk("sent", null, null, null);
                gkVar2.m517a(a3);
                gkVar.a(gkVar2);
                gmVarArr[i].a(gkVar);
            }
            b.c("SEND:" + gmVarArr[i].m520a());
            bundleArr[i] = gmVarArr[i].a();
        }
        if (length <= 0) {
            return false;
        }
        a2.setAction(bk.g);
        a2.putExtra(bk.F, f823a);
        a2.putExtra("ext_packets", bundleArr);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public void checkAlive() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a2);
    }

    public boolean closeChannel() {
        Intent a2 = a();
        a2.setAction(bk.i);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str) {
        Intent a2 = a();
        a2.setAction(bk.i);
        a2.putExtra(bk.t, str);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str, String str2) {
        Intent a2 = a();
        a2.setAction(bk.i);
        a2.putExtra(bk.t, str);
        a2.putExtra(bk.q, str2);
        return startServiceSafely(a2);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bk.j);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a2);
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f827a;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a2 = a();
        a2.setAction(bk.d);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
        return 0;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bk.k);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
    }

    public boolean sendIQ(gl glVar) {
        if (!bj.b(this.f824a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = glVar.a();
        if (a3 == null) {
            return false;
        }
        b.c("SEND:" + glVar.m519a());
        a2.setAction(bk.f);
        a2.putExtra(bk.F, f823a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(gm gmVar, boolean z) {
        if (!bj.b(this.f824a)) {
            return false;
        }
        Intent a2 = a();
        String a3 = et.a();
        if (!TextUtils.isEmpty(a3)) {
            gk gkVar = new gk(Constants.PARAM_PLATFORM_ID, null, null, null);
            gk gkVar2 = new gk("sent", null, null, null);
            gkVar2.m517a(a3);
            gkVar.a(gkVar2);
            gmVar.a(gkVar);
        }
        Bundle a4 = gmVar.a();
        if (a4 == null) {
            return false;
        }
        b.c("SEND:" + gmVar.m520a());
        a2.setAction(bk.e);
        a2.putExtra(bk.F, f823a);
        a2.putExtra("ext_packet", a4);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (!bj.b(this.f824a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.m182a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent a2 = a();
        a2.setAction(bk.e);
        a2.putExtra(bk.F, f823a);
        a2.putExtra("ext_raw_packet", bArr);
        int indexOf = str.indexOf(o70.DINAMIC_PREFIX_AT);
        String str4 = null;
        String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            str4 = str.substring(indexOf + 1, lastIndexOf);
            str3 = str.substring(lastIndexOf + 1);
        } else {
            str3 = null;
        }
        a2.putExtra(bk.q, substring);
        a2.putExtra(bk.r, str4);
        a2.putExtra(bk.s, str3);
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        long j = a;
        a = 1 + j;
        sb.append(j);
        String sb2 = sb.toString();
        a2.putExtra("ext_pkt_id", sb2);
        a2.putExtra("ext_chid", str2);
        b.e("SEND: chid=" + str2 + ", packetId=" + sb2);
        return startServiceSafely(a2);
    }

    public boolean sendPresence(gp gpVar) {
        if (!bj.b(this.f824a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = gpVar.a();
        if (a3 == null) {
            return false;
        }
        b.c("SEND:" + gpVar.m525a());
        a2.setAction(bk.h);
        a2.putExtra(bk.F, f823a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    public void setMessenger(Messenger messenger) {
        this.f825a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (m.m734a() || Build.VERSION.SDK_INT < 26) {
                this.f824a.startService(intent);
                return true;
            }
            m746a(intent);
            return true;
        } catch (Exception e) {
            b.a(e);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bk.l);
        if (map != null) {
            String a3 = a(map);
            if (!TextUtils.isEmpty(a3)) {
                a2.putExtra(bk.z, a3);
            }
        }
        if (map2 != null) {
            String a4 = a(map2);
            if (!TextUtils.isEmpty(a4)) {
                a2.putExtra(bk.A, a4);
            }
        }
        a2.putExtra(bk.t, str);
        startServiceSafely(a2);
    }
}
