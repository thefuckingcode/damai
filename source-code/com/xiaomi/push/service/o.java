package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.weex.common.Constants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gc;
import com.xiaomi.push.h;
import com.xiaomi.push.hg;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.m;
import com.xiaomi.push.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import tb.o70;

/* compiled from: Taobao */
public class o {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile o a;

    /* renamed from: a  reason: collision with other field name */
    private int f973a = -1;

    /* renamed from: a  reason: collision with other field name */
    private long f974a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f975a;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f976a;

    /* renamed from: a  reason: collision with other field name */
    private String f977a = null;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicInteger f978a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f979a = false;
    private String b = null;

    /* renamed from: b  reason: collision with other field name */
    private final AtomicInteger f980b = new AtomicInteger(0);

    /* renamed from: b  reason: collision with other field name */
    private final boolean f981b;
    private final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: c  reason: collision with other field name */
    private final boolean f982c;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    private o(Context context) {
        this.f975a = context;
        this.f982c = m.m735a(context);
        this.f981b = ba.a(context).a(ho.IntelligentHeartbeatSwitchBoolean.a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f976a = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.c(), -1) == -1) {
            sharedPreferences.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong(a.i(), -1);
        this.f974a = j;
        if (j == -1) {
            this.f974a = currentTimeMillis;
            sharedPreferences.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        if (TextUtils.isEmpty(this.f977a)) {
            return -1;
        }
        try {
            return this.f976a.getInt(a.a(this.f977a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static o a(Context context) {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    a = new o(context);
                }
            }
        }
        return a;
    }

    private void a(String str, String str2, Map<String, String> map) {
        hn hnVar = new hn();
        hnVar.d(str);
        hnVar.c("hb_name");
        hnVar.a("hb_channel");
        hnVar.a(1);
        hnVar.b(str2);
        hnVar.a(false);
        hnVar.b(System.currentTimeMillis());
        hnVar.g(this.f975a.getPackageName());
        hnVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        t a2 = u.m870a(this.f975a);
        if (a2 != null && !TextUtils.isEmpty(a2.f996a)) {
            String[] split = a2.f996a.split(o70.DINAMIC_PREFIX_AT);
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put("model", Build.getMODEL());
        Context context = this.f975a;
        map.put("avc", String.valueOf(h.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(40091));
        map.put("cvc", String.valueOf(48));
        hnVar.a(map);
        hg a3 = hg.a(this.f975a);
        if (a3 != null) {
            a3.a(hnVar, this.f975a.getPackageName());
        }
    }

    private void a(boolean z) {
        if (m850c()) {
            int incrementAndGet = (z ? this.f980b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            String str = "short";
            objArr[0] = z ? str : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d = z ? a.d() : a.e();
                int i = this.f976a.getInt(d, 0) + incrementAndGet;
                this.f976a.edit().putInt(d, i).apply();
                Object[] objArr2 = new Object[2];
                if (!z) {
                    str = "long";
                }
                objArr2[0] = str;
                objArr2[1] = Integer.valueOf(i);
                b.m182a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f980b : this.c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m848a() {
        return this.f978a.get() >= Math.max(ba.a(this.f975a).a(ho.IntelligentHeartbeatNATCountInt.a(), 5), 3);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private long b() {
        return this.f976a.getLong(a.j(), -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    private void b(String str) {
        int i;
        SharedPreferences.Editor remove;
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f977a;
            if (str2 == null || !str2.startsWith("W-")) {
                str = null;
            }
            i = this.f976a.getInt(a.a(this.f977a), -1);
            long j = this.f976a.getLong(a.b(this.f977a), -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (i != -1) {
                if (j == -1) {
                    remove = this.f976a.edit().putLong(a.b(this.f977a), currentTimeMillis + c());
                } else if (currentTimeMillis > j) {
                    remove = this.f976a.edit().remove(a.a(this.f977a)).remove(a.b(this.f977a));
                }
                remove.apply();
            }
            this.f978a.getAndSet(0);
            if (!TextUtils.isEmpty(this.f977a) || a() != -1) {
                this.f979a = false;
            } else {
                this.f979a = true;
            }
            b.m182a(String.format("[HB] network changed, netid:%s, %s", this.f977a, Boolean.valueOf(this.f979a)));
        }
        this.f977a = str;
        i = this.f976a.getInt(a.a(this.f977a), -1);
        long j2 = this.f976a.getLong(a.b(this.f977a), -1);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (i != -1) {
        }
        this.f978a.getAndSet(0);
        if (!TextUtils.isEmpty(this.f977a)) {
        }
        this.f979a = false;
        b.m182a(String.format("[HB] network changed, netid:%s, %s", this.f977a, Boolean.valueOf(this.f979a)));
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m849b() {
        return !TextUtils.isEmpty(this.f977a) && this.f977a.startsWith("M-") && !ba.a(this.f975a).a(ho.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false);
    }

    private long c() {
        return ba.a(this.f975a).a(ho.ShortHeartbeatEffectivePeriodMsLong.a(), 777600000L);
    }

    private void c(String str) {
        if (a(str)) {
            this.f976a.edit().putInt(a.a(str), 235000).apply();
            this.f976a.edit().putLong(a.b(this.f977a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m850c() {
        return d() && ba.a(this.f975a).a(ho.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && q.China.name().equals(a.a(this.f975a).a());
    }

    private void d(String str) {
        String str2;
        String str3;
        if (m850c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = ExifInterface.LONGITUDE_WEST;
            } else if (str.startsWith("M-")) {
                str2 = "M";
            } else {
                return;
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(valueOf);
            sb.append(":::");
            sb.append(valueOf2);
            String string = this.f976a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f976a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        return this.f982c && (this.f981b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    private void e() {
        if (!this.f976a.getBoolean(a.a(), false)) {
            this.f976a.edit().putBoolean(a.a(), true).apply();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m851e() {
        long j = this.f976a.getLong(a.c(), -1);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void f() {
        int i = this.f973a;
        String h = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (!TextUtils.isEmpty(h)) {
            if (this.f976a.getLong(a.i(), -1) == -1) {
                this.f974a = System.currentTimeMillis();
                this.f976a.edit().putLong(a.i(), this.f974a).apply();
            }
            this.f976a.edit().putInt(h, this.f976a.getInt(h, 0) + 1).apply();
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m852f() {
        if (this.f974a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f974a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void g() {
        int i;
        String[] split;
        String[] split2;
        if (m850c()) {
            String string = this.f976a.getString(a.f(), null);
            char c2 = 1;
            char c3 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < split.length) {
                    if (!TextUtils.isEmpty(split[i2]) && (split2 = split[i2].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c3];
                        String str2 = split2[c2];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", Constants.Event.CHANGE);
                        hashMap.put("model", Build.getMODEL());
                        hashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, str2);
                        hashMap.put("net_name", str);
                        hashMap.put(Constants.Name.INTERVAL, str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        b.m182a("[HB] report hb changed events.");
                    }
                    i2++;
                    c2 = 1;
                    c3 = 0;
                }
                this.f976a.edit().remove(a.f()).apply();
            }
            if (this.f976a.getBoolean(a.a(), false) && !this.f976a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.getMODEL());
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                b.m182a("[HB] report support wifi digest events.");
                this.f976a.edit().putBoolean(a.b(), true).apply();
            }
            if (m851e()) {
                int i3 = this.f976a.getInt(a.d(), 0);
                int i4 = this.f976a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f976a.getLong(a.c(), -1);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Constants.Name.INTERVAL, valueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put(AdUtConstants.XAD_UT_ARG_COUNT, String.valueOf(i3 + i4));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        b.m182a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f976a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m852f()) {
                String valueOf4 = String.valueOf(this.f974a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f976a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        b.m182a("[HB] report ping timeout count events of mobile network.");
                        this.f976a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f976a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f976a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, ExifInterface.LONGITUDE_WEST);
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        b.m182a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f976a.edit().putInt(a.h(), 0).apply();
                }
                this.f974a = System.currentTimeMillis();
                this.f976a.edit().putLong(a.i(), this.f974a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m853a() {
        int a2;
        long b2 = (long) gc.b();
        boolean z = true;
        if (this.f982c && !m849b() && ((ba.a(this.f975a).a(ho.IntelligentHeartbeatSwitchBoolean.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
            b2 = (long) a2;
        }
        if (!TextUtils.isEmpty(this.f977a) && !"WIFI-ID-UNKNOWN".equals(this.f977a) && this.f973a == 1) {
            if (b2 >= 300000) {
                z = false;
            }
            a(z);
        }
        b.m182a("[HB] ping interval:" + b2);
        return b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m854a() {
    }

    public void a(int i) {
        this.f976a.edit().putLong(a.j(), System.currentTimeMillis() + ((long) (i * 1000))).apply();
    }

    public synchronized void a(NetworkInfo networkInfo) {
        if (d()) {
            String str = null;
            if (networkInfo == null) {
                b(null);
            } else if (networkInfo.getType() == 0) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName) && !"UNKNOWN".equalsIgnoreCase(subtypeName)) {
                    str = "M-" + subtypeName;
                }
                b(str);
                this.f973a = 0;
            } else {
                if (networkInfo.getType() != 1) {
                    if (networkInfo.getType() != 6) {
                        b(null);
                    }
                }
                b("WIFI-ID-UNKNOWN");
                this.f973a = 1;
            }
            this.f973a = -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m855a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m856b() {
        if (d()) {
            f();
            if (this.f979a && !TextUtils.isEmpty(this.f977a) && this.f977a.equals(this.b)) {
                this.f978a.getAndIncrement();
                b.m182a("[HB] ping timeout count:" + this.f978a);
                if (m848a()) {
                    b.m182a("[HB] change hb interval for net:" + this.f977a);
                    c(this.f977a);
                    this.f979a = false;
                    this.f978a.getAndSet(0);
                    d(this.f977a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m857c() {
        if (d()) {
            this.b = this.f977a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m858d() {
        if (d()) {
            g();
            if (this.f979a) {
                this.f978a.getAndSet(0);
            }
        }
    }
}
