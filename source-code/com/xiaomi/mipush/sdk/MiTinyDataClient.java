package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.jl1;

/* compiled from: Taobao */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* compiled from: Taobao */
    public static class a {
        private static volatile a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f27a;

        /* renamed from: a  reason: collision with other field name */
        private C0252a f28a = new C0252a();

        /* renamed from: a  reason: collision with other field name */
        private Boolean f29a;

        /* renamed from: a  reason: collision with other field name */
        private String f30a;

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hn> f31a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0252a {

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f32a = new ab(this);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hn> f33a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f34a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f35a = new ScheduledThreadPoolExecutor(1);

            public C0252a() {
            }

            private void a() {
                if (this.f34a == null) {
                    this.f34a = this.f35a.scheduleAtFixedRate(this.f32a, 1000, 1000, TimeUnit.MILLISECONDS);
                }
            }

            /* access modifiers changed from: private */
            public void b() {
                hn remove = this.f33a.remove(0);
                for (ii iiVar : bz.a(Arrays.asList(remove), a.this.f27a.getPackageName(), b.m219a(a.this.f27a).m220a(), 30720)) {
                    b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ao.a(a.this.f27a).a((iu) iiVar, hj.Notification, true, (hw) null);
                }
            }

            public void a(hn hnVar) {
                this.f35a.execute(new aa(this, hnVar));
            }
        }

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        private void a(hn hnVar) {
            synchronized (this.f31a) {
                if (!this.f31a.contains(hnVar)) {
                    this.f31a.add(hnVar);
                    if (this.f31a.size() > 100) {
                        this.f31a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (!ao.a(context).m212a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                return packageInfo != null && packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean b(Context context) {
            return b.m219a(context).m220a() == null && !a(this.f27a);
        }

        private boolean b(hn hnVar) {
            if (bz.a(hnVar, false)) {
                return false;
            }
            if (this.f29a.booleanValue()) {
                b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hnVar.d());
                ao.a(this.f27a).a(hnVar);
                return true;
            }
            this.f28a.a(hnVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m195a(Context context) {
            if (context == null) {
                b.m182a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f27a = context;
            this.f29a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                b.m182a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f30a = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m196a() {
            return this.f27a != null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public synchronized boolean m197a(hn hnVar) {
            String str;
            boolean z = false;
            if (hnVar == null) {
                return false;
            }
            if (bz.a(hnVar, true)) {
                return false;
            }
            boolean z2 = TextUtils.isEmpty(hnVar.m551a()) && TextUtils.isEmpty(this.f30a);
            boolean z3 = !m196a();
            Context context = this.f27a;
            if (context == null || b(context)) {
                z = true;
            }
            if (z3 || z2 || z) {
                if (z2) {
                    str = "MiTinyDataClient Pending " + hnVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL;
                } else if (z3) {
                    str = "MiTinyDataClient Pending " + hnVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT;
                } else {
                    if (z) {
                        str = "MiTinyDataClient Pending " + hnVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID;
                    }
                    a(hnVar);
                    return true;
                }
                b.c(str);
                a(hnVar);
                return true;
            }
            b.c("MiTinyDataClient Send item immediately." + hnVar.d());
            if (TextUtils.isEmpty(hnVar.d())) {
                hnVar.f(bd.a());
            }
            if (TextUtils.isEmpty(hnVar.m551a())) {
                hnVar.a(this.f30a);
            }
            if (TextUtils.isEmpty(hnVar.c())) {
                hnVar.e(this.f27a.getPackageName());
            }
            if (hnVar.a() <= 0) {
                hnVar.b(System.currentTimeMillis());
            }
            return b(hnVar);
        }

        public void b(String str) {
            b.c("MiTinyDataClient.processPendingList(" + str + jl1.BRACKET_END_STR);
            ArrayList arrayList = new ArrayList();
            synchronized (this.f31a) {
                arrayList.addAll(this.f31a);
                this.f31a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m197a((hn) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            b.m182a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m195a(context);
        if (TextUtils.isEmpty(str)) {
            b.m182a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hn hnVar) {
        b.c("MiTinyDataClient.upload " + hnVar.d());
        if (!a.a().m196a()) {
            a.a().m195a(context);
        }
        return a.a().m197a(hnVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hn hnVar = new hn();
        hnVar.d(str);
        hnVar.c(str2);
        hnVar.a(j);
        hnVar.b(str3);
        hnVar.a(true);
        hnVar.a("push_sdk_channel");
        return upload(context, hnVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hn hnVar = new hn();
        hnVar.d(str);
        hnVar.c(str2);
        hnVar.a(j);
        hnVar.b(str3);
        return a.a().m197a(hnVar);
    }
}
