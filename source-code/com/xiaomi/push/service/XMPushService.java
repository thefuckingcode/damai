package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ae;
import com.xiaomi.push.al;
import com.xiaomi.push.ar;
import com.xiaomi.push.bj;
import com.xiaomi.push.bo;
import com.xiaomi.push.bt;
import com.xiaomi.push.cv;
import com.xiaomi.push.dd;
import com.xiaomi.push.df;
import com.xiaomi.push.ed;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.eu;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs;
import com.xiaomi.push.fw;
import com.xiaomi.push.fx;
import com.xiaomi.push.fz;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gh;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.hd;
import com.xiaomi.push.hg;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.it;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.p;
import com.xiaomi.push.v;
import com.xiaomi.push.w;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.jl1;
import tb.o70;

/* compiled from: Taobao */
public class XMPushService extends Service implements fz {
    private static boolean b;
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f832a = 0;

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f833a;

    /* renamed from: a  reason: collision with other field name */
    Messenger f834a = null;

    /* renamed from: a  reason: collision with other field name */
    private fs f835a;

    /* renamed from: a  reason: collision with other field name */
    private fw f836a;

    /* renamed from: a  reason: collision with other field name */
    private fx f837a;

    /* renamed from: a  reason: collision with other field name */
    private gb f838a = new ci(this);

    /* renamed from: a  reason: collision with other field name */
    private a f839a;

    /* renamed from: a  reason: collision with other field name */
    private f f840a;

    /* renamed from: a  reason: collision with other field name */
    private k f841a;

    /* renamed from: a  reason: collision with other field name */
    private r f842a;

    /* renamed from: a  reason: collision with other field name */
    private t f843a;

    /* renamed from: a  reason: collision with other field name */
    private be f844a = null;

    /* renamed from: a  reason: collision with other field name */
    private bq f845a;

    /* renamed from: a  reason: collision with other field name */
    private j f846a;

    /* renamed from: a  reason: collision with other field name */
    private p f847a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Class f848a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private String f849a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<n> f850a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private Collection<ar> f851a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private boolean f852a = false;

    /* renamed from: b  reason: collision with other field name */
    private int f853b = 0;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        private final Object f854a;

        private a() {
            this.f854a = new Object();
        }

        /* synthetic */ a(XMPushService xMPushService, ci ciVar) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f854a) {
                try {
                    this.f854a.notifyAll();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("[Alarm] notify lock. " + e);
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f854a) {
                try {
                    this.f854a.wait(j);
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("[Alarm] interrupt from waiting state. " + e);
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!bk.p.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m182a("[Alarm] cancel the old ping timer");
                eu.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000);
                    com.xiaomi.channel.commonutils.logger.b.m182a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f855a = null;

        public b(bg.b bVar) {
            super(9);
            this.f855a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind the client. " + this.f855a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m765a() {
            String str;
            try {
                if (!XMPushService.this.m763c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                bg a2 = bg.a();
                bg.b bVar = this.f855a;
                bg.b a3 = a2.a(bVar.g, bVar.f928b);
                if (a3 == null) {
                    str = "ignore bind because the channel " + this.f855a.g + " is removed ";
                } else if (a3.f923a == bg.c.unbind) {
                    a3.a(bg.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f836a.a(a3);
                    fj.a(XMPushService.this, a3);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a3.f923a;
                }
                com.xiaomi.channel.commonutils.logger.b.m182a(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c extends j {
        private final bg.b a;

        public c(bg.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind time out. chid=" + this.a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m766a() {
            this.a.a(bg.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return TextUtils.equals(((c) obj).a.g, this.a.g);
        }

        public int hashCode() {
            return this.a.g.hashCode();
        }
    }

    /* compiled from: Taobao */
    class d extends j {
        private fl a = null;

        public d(fl flVar) {
            super(8);
            this.a = flVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public fl a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public String m767a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m768a() {
            ao aoVar = this.a.f364a;
            if (aoVar != null) {
                aoVar.c = System.currentTimeMillis();
            }
            XMPushService.this.f844a.a(this.a);
        }
    }

    /* compiled from: Taobao */
    public class e extends j {
        e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m769a() {
            if (XMPushService.this.m758a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a((XMPushService) xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m182a("should not connect. quit the job.");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f extends BroadcastReceiver {
        f() {
        }

        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m182a("network changed, " + com.xiaomi.push.m.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* compiled from: Taobao */
    public class g extends j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f857a;
        public int b;

        g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f857a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m770a() {
            XMPushService.this.a(this.b, this.f857a);
        }
    }

    /* compiled from: Taobao */
    class h extends j {
        h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m771a() {
            XMPushService.this.c();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class i extends j {
        private Intent a = null;

        public i(Intent intent) {
            super(15);
            this.a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public Intent a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public String m772a() {
            return "Handle intent action = " + this.a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m773a() {
            XMPushService.this.d(this.a);
        }
    }

    /* compiled from: Taobao */
    public static abstract class j extends p.b {
        public j(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m774a();

        public void run() {
            int i = this.a;
            if (!(i == 4 || i == 8)) {
                com.xiaomi.channel.commonutils.logger.b.m183a(com.xiaomi.channel.commonutils.logger.a.a, a());
            }
            m774a();
        }
    }

    /* compiled from: Taobao */
    class k extends BroadcastReceiver {
        k() {
        }

        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m182a("[HB] hold short heartbeat, " + com.xiaomi.push.m.a(intent));
            if (intent != null && intent.getExtras() != null) {
                XMPushService.this.onStart(intent, 1);
            }
        }
    }

    /* compiled from: Taobao */
    class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m775a() {
            XMPushService.this.f847a.m859a();
        }
    }

    /* compiled from: Taobao */
    class m extends j {
        private gn a = null;

        public m(gn gnVar) {
            super(8);
            this.a = gnVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m776a() {
            XMPushService.this.f844a.a(this.a);
        }
    }

    /* compiled from: Taobao */
    public interface n {
        void a();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class o extends j {

        /* renamed from: a  reason: collision with other field name */
        boolean f860a;

        public o(boolean z) {
            super(4);
            this.f860a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m777a() {
            if (XMPushService.this.m763c()) {
                try {
                    if (!this.f860a) {
                        fj.a();
                    }
                    XMPushService.this.f836a.b(this.f860a);
                } catch (gh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class p extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f861a = null;

        public p(bg.b bVar) {
            super(4);
            this.f861a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "rebind the client. " + this.f861a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m778a() {
            try {
                this.f861a.a(bg.c.unbind, 1, 16, (String) null, (String) null);
                fw fwVar = XMPushService.this.f836a;
                bg.b bVar = this.f861a;
                fwVar.a(bVar.g, bVar.f928b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new b(this.f861a), 300);
            } catch (gh e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class q extends j {
        q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m779a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m758a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a((XMPushService) xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    /* compiled from: Taobao */
    class r extends BroadcastReceiver {
        r() {
        }

        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class s extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f862a = null;

        /* renamed from: a  reason: collision with other field name */
        String f863a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f864b;

        public s(bg.b bVar, int i, String str, String str2) {
            super(9);
            this.f862a = bVar;
            this.b = i;
            this.f863a = str;
            this.f864b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "unbind the channel. " + this.f862a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public void m780a() {
            if (!(this.f862a.f923a == bg.c.unbind || XMPushService.this.f836a == null)) {
                try {
                    fw fwVar = XMPushService.this.f836a;
                    bg.b bVar = this.f862a;
                    fwVar.a(bVar.g, bVar.f928b);
                } catch (gh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f862a.a(bg.c.unbind, this.b, 0, this.f864b, this.f863a);
        }
    }

    /* compiled from: Taobao */
    class t extends BroadcastReceiver {
        t() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f852a) {
                XMPushService.this.f852a = true;
            }
            com.xiaomi.channel.commonutils.logger.b.m182a("[HB] wifi changed, " + com.xiaomi.push.m.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    private gn a(gn gnVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        bg a2 = bg.a();
        List<String> a3 = a2.m824a(str);
        if (a3.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            gnVar.o(str);
            str = gnVar.k();
            if (TextUtils.isEmpty(str)) {
                str = a3.get(0);
                gnVar.l(str);
            }
            bg.b a4 = a2.a(str, gnVar.m());
            if (!m763c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a4 == null || a4.f923a != bg.c.binded) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            } else if (TextUtils.equals(str2, a4.i)) {
                return gnVar;
            } else {
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.m182a(sb.toString());
                return null;
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.m182a(sb.toString());
        return null;
    }

    private bg.b a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        if (a2 == null) {
            a2 = new bg.b(this);
        }
        a2.g = intent.getStringExtra(bk.t);
        a2.f928b = intent.getStringExtra(bk.q);
        a2.c = intent.getStringExtra(bk.v);
        a2.f925a = intent.getStringExtra(bk.B);
        a2.e = intent.getStringExtra(bk.z);
        a2.f = intent.getStringExtra(bk.A);
        a2.f927a = intent.getBooleanExtra(bk.y, false);
        a2.h = intent.getStringExtra(bk.x);
        a2.i = intent.getStringExtra(bk.F);
        a2.d = intent.getStringExtra(bk.w);
        a2.f924a = this.f846a;
        a2.a((Messenger) intent.getParcelableExtra(bk.J));
        a2.f917a = getApplicationContext();
        bg.a().a(a2);
        return a2;
    }

    private String a() {
        String a2 = com.xiaomi.push.m.m732a("ro.miui.region");
        return TextUtils.isEmpty(a2) ? com.xiaomi.push.m.m732a("ro.product.locale.region") : a2;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            o.a(getApplicationContext()).m855a(extras.getString("digest"));
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ii iiVar = new ii();
        try {
            it.a(iiVar, byteArrayExtra);
            al.a(getApplicationContext()).a((al.a) new b(iiVar, new WeakReference(this), booleanExtra), i2);
        } catch (iz unused) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(a aVar) {
        String str;
        String str2;
        if (aVar == null || !TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.a())) {
            str = "no need to check country code";
        } else {
            String a2 = "com.xiaomi.xmsf".equals(getPackageName()) ? a() : com.xiaomi.push.m.b();
            if (!TextUtils.isEmpty(a2)) {
                String name = com.xiaomi.push.m.a(a2).name();
                if (TextUtils.equals(name, aVar.a())) {
                    aVar.b(a2);
                    str2 = "update country code";
                } else {
                    str2 = "not update country code, because not equals " + name;
                }
                com.xiaomi.channel.commonutils.logger.b.m182a(str2);
                return;
            }
            str = "check no country code";
        }
        com.xiaomi.channel.commonutils.logger.b.b(str);
    }

    private static void a(String str) {
        String str2;
        String str3;
        if (com.xiaomi.push.q.China.name().equals(str)) {
            cv.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            cv.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            cv.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            cv.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            cv.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            str2 = "resolver.msg.xiaomi.net";
            cv.a(str2, "111.13.142.153:443");
            str3 = "111.202.1.252:443";
        } else {
            cv.a("app.chat.global.xiaomi.net", "app.chat.global.xiaomi.net");
            str2 = "resolver.msg.global.xiaomi.net";
            cv.a(str2, "161.117.97.14:443");
            str3 = "161.117.180.178:443";
        }
        cv.a(str2, str3);
    }

    private void a(String str, int i2) {
        Collection<bg.b> a2 = bg.a().m823a(str);
        if (a2 != null) {
            for (bg.b bVar : a2) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        bg.a().m826a(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean a(Context context) {
        try {
            ar.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (bj.c(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m748a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bk.F);
        String stringExtra2 = intent.getStringExtra(bk.x);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m182a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("security changed. chid = " + str + " sechash = " + bo.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m749a() {
        String[] split;
        String a2 = ba.a(getApplicationContext()).a(ho.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] < 0 || iArr[0] > 23 || iArr[1] < 0 || iArr[1] > 23 || iArr[0] == iArr[1]) {
                    return null;
                }
                return iArr;
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private String b() {
        String str;
        ar.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str2 = null;
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bn a2 = bn.a(this);
            String str3 = null;
            while (true) {
                if (!TextUtils.isEmpty(str3) && a2.a() != 0) {
                    str = a();
                    break;
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000);
                        } else {
                            obj.wait(30000);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
        } else {
            str = com.xiaomi.push.m.b();
        }
        if (!TextUtils.isEmpty(str)) {
            a.a(getApplicationContext()).b(str);
            str2 = com.xiaomi.push.m.a(str).name();
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("wait region :" + str2 + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i2);
        return str2;
    }

    private void b(Intent intent) {
        fl flVar;
        long j2;
        String str;
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        bg a2 = bg.a();
        if (bundleExtra != null) {
            gm gmVar = (gm) a(new gm(bundleExtra), stringExtra, stringExtra2);
            if (gmVar != null) {
                flVar = fl.a(gmVar, a2.a(gmVar.k(), gmVar.m()).h);
            } else {
                return;
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(bk.q));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(bk.r);
                String stringExtra4 = intent.getStringExtra(bk.s);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                bg.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                if (a3 != null) {
                    fl flVar2 = new fl();
                    if ("10".equals(stringExtra5)) {
                        flVar2.b(Integer.parseInt("10"));
                        flVar2.f364a.f893a = intent.getBooleanExtra("screen_on", true);
                        flVar2.f364a.f895b = intent.getBooleanExtra("wifi", true);
                        str = stringExtra3;
                        flVar2.f364a.f892a = intent.getLongExtra("rx_msg", -1);
                        flVar2.f364a.f894b = intent.getLongExtra("enqueue", -1);
                        flVar2.f364a.b = intent.getIntExtra(GiftNumBean.KEY_NUM, -1);
                        flVar2.f364a.c = intent.getLongExtra("run", -1);
                    } else {
                        str = stringExtra3;
                    }
                    try {
                        flVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    flVar2.a("SECMSG", (String) null);
                    flVar2.a(j2, TextUtils.isEmpty(str) ? "xiaomi.com" : str, stringExtra4);
                    flVar2.a(intent.getStringExtra("ext_pkt_id"));
                    flVar2.a(byteArrayExtra, a3.h);
                    com.xiaomi.channel.commonutils.logger.b.m182a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    flVar = flVar2;
                }
            }
            flVar = null;
        }
        if (flVar != null) {
            c(new bt(this, flVar));
        }
    }

    private void b(boolean z) {
        this.f832a = SystemClock.elapsedRealtime();
        if (m763c()) {
            if (bj.b(this)) {
                c(new o(z));
                return;
            }
            c(new g(17, null));
        }
        a(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        String str;
        a a2 = a.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.channel.commonutils.logger.b.m182a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = b();
        } else {
            a(a2);
        }
        if (!TextUtils.isEmpty(a3)) {
            this.f849a = a3;
            a2.a(a3);
            if (com.xiaomi.push.q.Global.name().equals(this.f849a)) {
                str = "app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.q.Europe.name().equals(this.f849a)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.q.Russia.name().equals(this.f849a)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.q.India.name().equals(this.f849a)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            fx.a(str);
        } else {
            this.f849a = com.xiaomi.push.q.China.name();
        }
        if (com.xiaomi.push.q.China.name().equals(this.f849a)) {
            fx.a("cn.app.chat.xiaomi.net");
        }
        a(this.f849a);
        if (m753h()) {
            cs csVar = new cs(this, 11);
            a(csVar);
            u.a(new ct(this, csVar));
        }
        try {
            if (v.m881a()) {
                this.f846a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        gm[] gmVarArr = new gm[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            gmVarArr[i2] = new gm((Bundle) parcelableArrayExtra[i2]);
            gmVarArr[i2] = (gm) a(gmVarArr[i2], stringExtra, stringExtra2);
            if (gmVarArr[i2] == null) {
                return;
            }
        }
        bg a2 = bg.a();
        fl[] flVarArr = new fl[length];
        for (int i3 = 0; i3 < length; i3++) {
            gm gmVar = gmVarArr[i3];
            flVarArr[i3] = fl.a(gmVar, a2.a(gmVar.k(), gmVar.m()).h);
        }
        c(new c(this, flVarArr));
    }

    private void c(j jVar) {
        this.f847a.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (!v.m881a()) {
                return;
            }
            if (z) {
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ar arVar : (ar[]) this.f851a.toArray(new ar[0])) {
                    arVar.a();
                }
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) getSystemService("connectivity"));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            networkInfo = null;
        }
        o.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append(jl1.ARRAY_START_STR + "type: " + networkInfo.getTypeName() + jl1.ARRAY_START_STR + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.m182a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m182a("network changed, no active network");
        }
        if (fh.a() != null) {
            fh.a().m473a();
        }
        hb.m544a((Context) this);
        this.f835a.d();
        if (bj.b(this)) {
            if (m763c() && m751f()) {
                b(false);
            }
            if (!m763c() && !m764d()) {
                this.f847a.a(1);
                a(new e());
            }
            df.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0426  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    private void d(Intent intent) {
        String str;
        j jVar;
        boolean z;
        int i2;
        String format;
        j pVar;
        int i3;
        String str2;
        SharedPreferences sharedPreferences;
        Object th;
        String str3;
        j btVar;
        bg a2 = bg.a();
        boolean z2 = true;
        boolean z3 = false;
        int i4 = 0;
        if (bk.d.equalsIgnoreCase(intent.getAction()) || bk.j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(bk.t);
            if (TextUtils.isEmpty(intent.getStringExtra(bk.x))) {
                format = "security is empty. ignore.";
            } else if (!TextUtils.isEmpty(stringExtra)) {
                boolean a3 = m748a(stringExtra, intent);
                bg.b a4 = a(stringExtra, intent);
                if (!bj.c(this)) {
                    jVar = this.f846a;
                    z = false;
                    i2 = 2;
                } else {
                    if (m763c()) {
                        bg.c cVar = a4.f923a;
                        if (cVar == bg.c.unbind) {
                            pVar = new b(a4);
                        } else if (a3) {
                            pVar = new p(a4);
                        } else if (cVar == bg.c.binding) {
                            format = String.format("the client is binding. %1$s %2$s.", a4.g, bg.b.a(a4.f928b));
                        } else if (cVar == bg.c.binded) {
                            jVar = this.f846a;
                            z = true;
                            i2 = 0;
                        } else {
                            return;
                        }
                    }
                    a(true);
                    return;
                }
                jVar.a(this, a4, z, i2, null);
                return;
            } else {
                str = "channel id is empty, do nothing!";
                com.xiaomi.channel.commonutils.logger.b.d(str);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m182a(format);
            return;
        } else if (bk.i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(bk.B);
            String stringExtra3 = intent.getStringExtra(bk.t);
            String stringExtra4 = intent.getStringExtra(bk.q);
            com.xiaomi.channel.commonutils.logger.b.m182a("Service called close channel chid = " + stringExtra3 + " res = " + bg.b.a(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str4 : a2.m824a(stringExtra2)) {
                    a(str4, 2);
                }
                return;
            } else if (TextUtils.isEmpty(stringExtra4)) {
                a(stringExtra3, 2);
                return;
            } else {
                a(stringExtra3, stringExtra4, 2, null, null);
                return;
            }
        } else if (bk.e.equalsIgnoreCase(intent.getAction())) {
            if ("10".equals(intent.getStringExtra("ext_chid"))) {
                intent.putExtra("run", System.currentTimeMillis());
            }
            b(intent);
            return;
        } else if (bk.g.equalsIgnoreCase(intent.getAction())) {
            c(intent);
            return;
        } else {
            if (bk.f.equalsIgnoreCase(intent.getAction())) {
                gn a5 = a(new gl(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bk.B), intent.getStringExtra(bk.F));
                if (a5 != null) {
                    btVar = new bt(this, fl.a(a5, a2.a(a5.k(), a5.m()).h));
                } else {
                    return;
                }
            } else if (bk.h.equalsIgnoreCase(intent.getAction())) {
                gn a6 = a(new gp(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bk.B), intent.getStringExtra(bk.F));
                if (a6 != null) {
                    btVar = new bt(this, fl.a(a6, a2.a(a6.k(), a6.m()).h));
                } else {
                    return;
                }
            } else if (bk.k.equals(intent.getAction())) {
                String stringExtra5 = intent.getStringExtra(bk.t);
                String stringExtra6 = intent.getStringExtra(bk.q);
                if (stringExtra5 != null) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("request reset connection from chid = " + stringExtra5);
                    bg.b a7 = bg.a().a(stringExtra5, stringExtra6);
                    if (a7 != null && a7.h.equals(intent.getStringExtra(bk.x)) && a7.f923a == bg.c.binded) {
                        fw a8 = m755a();
                        if (a8 == null || !a8.a(SystemClock.elapsedRealtime() - 15000)) {
                            pVar = new q();
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                String str5 = null;
                r2 = null;
                bg.b bVar = null;
                str5 = null;
                if (bk.l.equals(intent.getAction())) {
                    String stringExtra7 = intent.getStringExtra(bk.B);
                    List<String> a9 = a2.m824a(stringExtra7);
                    if (a9.isEmpty()) {
                        str3 = "open channel should be called first before update info, pkg=" + stringExtra7;
                    } else {
                        String stringExtra8 = intent.getStringExtra(bk.t);
                        String stringExtra9 = intent.getStringExtra(bk.q);
                        if (TextUtils.isEmpty(stringExtra8)) {
                            stringExtra8 = a9.get(0);
                        }
                        if (TextUtils.isEmpty(stringExtra9)) {
                            Collection<bg.b> a10 = a2.m823a(stringExtra8);
                            if (a10 != null && !a10.isEmpty()) {
                                bVar = a10.iterator().next();
                            }
                        } else {
                            bVar = a2.a(stringExtra8, stringExtra9);
                        }
                        if (bVar != null) {
                            if (intent.hasExtra(bk.z)) {
                                bVar.e = intent.getStringExtra(bk.z);
                            }
                            if (intent.hasExtra(bk.A)) {
                                bVar.f = intent.getStringExtra(bk.A);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                        if (!m754i()) {
                            com.xiaomi.channel.commonutils.logger.b.m182a("exit falldown mode, activate alarm.");
                            e();
                            if (m763c() || m764d()) {
                                return;
                            }
                            a(true);
                            return;
                        }
                        return;
                    } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m754i() && eu.m463a()) {
                        com.xiaomi.channel.commonutils.logger.b.m182a("enter falldown mode, stop alarm.");
                        eu.a();
                        return;
                    } else {
                        return;
                    }
                } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                    if (!bn.a(getApplicationContext()).m833a() || bn.a(getApplicationContext()).a() != 0) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                        String stringExtra10 = intent.getStringExtra("mipush_app_package");
                        boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                        int intExtra = intent.getIntExtra("mipush_env_type", 1);
                        v.a(this).d(stringExtra10);
                        if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                            a(byteArrayExtra, stringExtra10);
                            return;
                        }
                        pVar = new cu(this, 14, intExtra, stringExtra10, byteArrayExtra);
                    } else {
                        str3 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                    }
                } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    String stringExtra11 = intent.getStringExtra("mipush_app_package");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    if (m.a(byteArrayExtra2, stringExtra11)) {
                        format = "duplicate msg from: " + String.valueOf(stringExtra11);
                        com.xiaomi.channel.commonutils.logger.b.m182a(format);
                        return;
                    }
                    if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                        v.a(this).a(stringExtra11);
                        if (com.xiaomi.push.m.m735a(getApplicationContext())) {
                            ag.a(stringExtra11);
                        }
                    }
                    a(stringExtra11, byteArrayExtra2, booleanExtra2);
                    return;
                } else if (bo.a.equals(intent.getAction())) {
                    String stringExtra12 = intent.getStringExtra("uninstall_pkg_name");
                    if (stringExtra12 != null && !TextUtils.isEmpty(stringExtra12.trim())) {
                        try {
                            PackageInfo packageInfo = getPackageManager().getPackageInfo(stringExtra12, 0);
                            if (packageInfo == null || packageInfo.applicationInfo == null || !com.xiaomi.push.j.a(this, packageInfo.packageName)) {
                                z2 = false;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m182a("dual space's app uninstalled " + stringExtra12);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if (!"com.xiaomi.channel".equals(stringExtra12) || bg.a().m823a("1").isEmpty() || !z2) {
                            SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
                            String string = sharedPreferences2.getString(stringExtra12, null);
                            if (!TextUtils.isEmpty(string) && z2) {
                                SharedPreferences.Editor edit = sharedPreferences2.edit();
                                edit.remove(stringExtra12);
                                edit.commit();
                                if (al.m799b((Context) this, stringExtra12)) {
                                    al.c(this, stringExtra12);
                                }
                                al.m793a((Context) this, stringExtra12);
                                at.a(getApplicationContext(), stringExtra12);
                                if (m763c() && string != null) {
                                    try {
                                        ah.a(this, ah.a(stringExtra12, string));
                                        com.xiaomi.channel.commonutils.logger.b.m182a("uninstall " + stringExtra12 + " msg sent");
                                        return;
                                    } catch (gh e2) {
                                        com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e2.getMessage());
                                        a(10, e2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            a("1", 0);
                            str3 = "close the miliao channel as the app is uninstalled.";
                        }
                    } else {
                        return;
                    }
                } else if (bo.b.equals(intent.getAction())) {
                    String stringExtra13 = intent.getStringExtra("data_cleared_pkg_name");
                    if (!TextUtils.isEmpty(stringExtra13)) {
                        try {
                            sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                            if (sharedPreferences != null) {
                                try {
                                    str5 = sharedPreferences.getString(stringExtra13, null);
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.xiaomi.channel.commonutils.logger.b.m182a("Fail to get sp or appId : " + th);
                                    if (!TextUtils.isEmpty(str5)) {
                                    }
                                    at.a((Context) this, stringExtra13);
                                    if (com.xiaomi.push.m.m735a(getApplicationContext())) {
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            sharedPreferences = null;
                            com.xiaomi.channel.commonutils.logger.b.m182a("Fail to get sp or appId : " + th);
                            if (!TextUtils.isEmpty(str5)) {
                            }
                            at.a((Context) this, stringExtra13);
                            if (com.xiaomi.push.m.m735a(getApplicationContext())) {
                            }
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            SharedPreferences.Editor edit2 = sharedPreferences.edit();
                            edit2.remove(stringExtra13);
                            edit2.commit();
                            if (al.m799b((Context) this, stringExtra13)) {
                                al.c(this, stringExtra13);
                            }
                            al.m793a((Context) this, stringExtra13);
                            a(stringExtra13, it.a(ah.b(stringExtra13, str5)), true);
                        }
                        at.a((Context) this, stringExtra13);
                        if (com.xiaomi.push.m.m735a(getApplicationContext())) {
                            ag.a(stringExtra13);
                            return;
                        }
                        return;
                    }
                    return;
                } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                    String stringExtra14 = intent.getStringExtra(bk.B);
                    int intExtra2 = intent.getIntExtra(bk.C, -2);
                    if (TextUtils.isEmpty(stringExtra14)) {
                        return;
                    }
                    if (intExtra2 >= -1) {
                        al.a(this, stringExtra14, intExtra2, intent.getIntExtra(bk.D, -1));
                        return;
                    } else {
                        al.a(this, stringExtra14, intent.getStringExtra(bk.H), intent.getStringExtra(bk.I));
                        return;
                    }
                } else if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
                    String stringExtra15 = intent.getStringExtra(bk.B);
                    if (!TextUtils.isEmpty(stringExtra15)) {
                        al.m798b((Context) this, stringExtra15);
                        return;
                    }
                    return;
                } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                    String stringExtra16 = intent.getStringExtra(bk.B);
                    String stringExtra17 = intent.getStringExtra(bk.G);
                    if (intent.hasExtra(bk.E)) {
                        int intExtra3 = intent.getIntExtra(bk.E, 0);
                        str2 = bo.b(stringExtra16 + intExtra3);
                        i4 = intExtra3;
                        z2 = false;
                    } else {
                        str2 = bo.b(stringExtra16);
                    }
                    if (TextUtils.isEmpty(stringExtra16) || !TextUtils.equals(stringExtra17, str2)) {
                        str = "invalid notification for " + stringExtra16;
                        com.xiaomi.channel.commonutils.logger.b.d(str);
                        return;
                    } else if (z2) {
                        al.c(this, stringExtra16);
                        return;
                    } else {
                        al.b(this, stringExtra16, i4);
                        return;
                    }
                } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                    String stringExtra18 = intent.getStringExtra("mipush_app_package");
                    if (!TextUtils.isEmpty(stringExtra18)) {
                        v.a(this).b(stringExtra18);
                    }
                    if (!"com.xiaomi.xmsf".equals(getPackageName())) {
                        a(19, (Exception) null);
                        e();
                        stopSelf();
                        return;
                    }
                    return;
                } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                    String stringExtra19 = intent.getStringExtra("mipush_app_package");
                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                    String stringExtra20 = intent.getStringExtra("mipush_app_id");
                    String stringExtra21 = intent.getStringExtra("mipush_app_token");
                    if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        v.a(this).c(stringExtra19);
                    }
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        v.a(this).e(stringExtra19);
                        v.a(this).f(stringExtra19);
                    }
                    if (byteArrayExtra3 == null) {
                        x.a(this, stringExtra19, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                        return;
                    }
                    x.b(stringExtra19, byteArrayExtra3);
                    a(new w(this, stringExtra19, stringExtra20, stringExtra21, byteArrayExtra3));
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f840a == null) {
                        this.f840a = new f();
                        registerReceiver(this.f840a, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
                        return;
                    }
                    return;
                } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                    String stringExtra22 = intent.getStringExtra("mipush_app_package");
                    byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                    hn hnVar = new hn();
                    try {
                        it.a(hnVar, byteArrayExtra4);
                        hg.a(this).a(hnVar, stringExtra22);
                        return;
                    } catch (iz e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                        return;
                    }
                } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("[Alarm] Service called on timer");
                    if (!m754i()) {
                        eu.a(false);
                        if (m751f()) {
                            b(false);
                        }
                    } else if (eu.m463a()) {
                        com.xiaomi.channel.commonutils.logger.b.m182a("enter falldown mode, stop alarm");
                        eu.a();
                    }
                    a aVar = this.f839a;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("Service called on check alive.");
                    if (m751f()) {
                        b(false);
                        return;
                    }
                    return;
                } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                    eu.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                    return;
                } else if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                    d();
                    return;
                } else if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    a(intent);
                    return;
                } else if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
                    if (intent.getExtras() != null && (i3 = intent.getExtras().getInt("effectivePeriod", 0)) > 0 && i3 <= 604800) {
                        o.a(getApplicationContext()).a(i3);
                        return;
                    }
                    return;
                } else if ("action_cr_config".equals(intent.getAction())) {
                    boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                    long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400);
                    boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                    long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400);
                    boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                    long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576);
                    Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(bt.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
                    if (!"com.xiaomi.xmsf".equals(getPackageName()) && longExtra > 0 && longExtra2 > 0 && longExtra3 > 0) {
                        en.a(getApplicationContext(), build);
                        return;
                    }
                    return;
                } else if ("action_help_ping".equals(intent.getAction())) {
                    boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                    int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                    if (intExtra4 >= 0 && intExtra4 < 30) {
                        com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                        intExtra4 = 30;
                    }
                    if (intExtra4 >= 0) {
                        z3 = booleanExtra6;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m182a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                    if (z3 && intExtra4 > 0 && !"com.xiaomi.xmsf".equals(getPackageName())) {
                        a(intent, intExtra4);
                        return;
                    }
                    return;
                } else if ("action_aw_app_logic".equals(intent.getAction())) {
                    e(intent);
                    return;
                } else if (bk.n.equals(intent.getAction())) {
                    n.a(getApplicationContext(), intent);
                    return;
                } else {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m182a(str3);
                return;
            }
            c(btVar);
            return;
        }
        c(pVar);
    }

    private void e() {
        if (!m758a()) {
            eu.a();
        } else if (!eu.m463a()) {
            eu.a(true);
        }
    }

    private void e(Intent intent) {
        int i2;
        try {
            ed.a(getApplicationContext()).a(new bm());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra != null) {
                ii iiVar = new ii();
                it.a(iiVar, byteArrayExtra);
                String b2 = iiVar.b();
                Map<String, String> a2 = iiVar.m633a();
                if (a2 != null) {
                    String str = a2.get("extra_help_aw_info");
                    String str2 = a2.get("extra_aw_app_online_cmd");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            i2 = Integer.parseInt(str2);
                        } catch (NumberFormatException unused) {
                            i2 = 0;
                        }
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(b2) && !TextUtils.isEmpty(str)) {
                            ed.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
                        }
                    }
                }
            }
        } catch (iz e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m750e() {
        return b;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        String str;
        fw fwVar = this.f836a;
        if (fwVar == null || !fwVar.m504b()) {
            fw fwVar2 = this.f836a;
            if (fwVar2 == null || !fwVar2.m505c()) {
                this.f837a.b(bj.m282a((Context) this));
                g();
                if (this.f836a == null) {
                    bg.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m751f() {
        if (SystemClock.elapsedRealtime() - this.f832a < 30000) {
            return false;
        }
        return bj.d(this);
    }

    private void g() {
        try {
            this.f835a.a(this.f838a, new cl(this));
            this.f835a.e();
            this.f836a = this.f835a;
        } catch (gh e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f835a.b(3, e2);
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private boolean m752g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m753h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !v.a(this).m875b(getPackageName());
    }

    private void i() {
        synchronized (this.f850a) {
            this.f850a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m754i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.j.m690b(this) && !com.xiaomi.push.j.m688a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.a;
        int i3 = this.f853b;
        if (i2 <= i3) {
            return i2 < i3 && intValue >= i2 && intValue < i3;
        }
        if (intValue >= i2 || intValue < i3) {
            return true;
        }
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ba.a(this).a(ho.ForegroundServiceSwitch.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fw m755a() {
        return this.f836a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public j m756a() {
        return new j();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m757a() {
        if (SystemClock.elapsedRealtime() - this.f832a >= ((long) gc.a()) && bj.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f847a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(AVFSCacheConstants.COMMA_SEP);
        fw fwVar = this.f836a;
        sb.append(fwVar == null ? null : Integer.valueOf(fwVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m182a(sb.toString());
        fw fwVar2 = this.f836a;
        if (fwVar2 != null) {
            fwVar2.b(i2, exc);
            this.f836a = null;
        }
        a(7);
        a(4);
        bg.a().a(this, i2);
    }

    public void a(fl flVar) {
        fw fwVar = this.f836a;
        if (fwVar != null) {
            fwVar.b(flVar);
            return;
        }
        throw new gh("try send msg while connection is null.");
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        fh.a().a(fwVar);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i2, Exception exc) {
        fh.a().a(fwVar, i2, exc);
        if (!m754i()) {
            a(false);
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        fh.a().a(fwVar, exc);
        c(false);
        if (!m754i()) {
            a(false);
        }
    }

    public void a(j jVar) {
        a(jVar, 0);
    }

    public void a(j jVar, long j2) {
        try {
            this.f847a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m182a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(n nVar) {
        synchronized (this.f850a) {
            this.f850a.add(nVar);
        }
    }

    public void a(bg.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m182a("schedule rebind job in " + (a2 / 1000));
            a(new b(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        bg.b a2 = bg.a().a(str, str2);
        if (a2 != null) {
            a(new s(a2, i2, str4, str3));
        }
        bg.a().m827a(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<bg.b> a2 = bg.a().m823a("5");
        if (a2.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (a2.iterator().next().f923a == bg.c.binded) {
            a(new cj(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        x.b(str, bArr);
    }

    public void a(boolean z) {
        this.f845a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m182a("register request without payload");
            return;
        }
        Cif ifVar = new Cif();
        try {
            it.a(ifVar, bArr);
            if (ifVar.f617a == hj.Registration) {
                ij ijVar = new ij();
                try {
                    it.a(ijVar, ifVar.m623a());
                    a(new w(this, ifVar.b(), ijVar.b(), ijVar.c(), bArr));
                    eo.a(getApplicationContext()).a(ifVar.b(), "E100003", ijVar.a(), 6002, null);
                } catch (iz e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m182a("register request with invalid payload");
            }
        } catch (iz e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(fl[] flVarArr) {
        fw fwVar = this.f836a;
        if (fwVar != null) {
            fwVar.a(flVarArr);
            return;
        }
        throw new gh("try send msg while connection is null.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m758a() {
        boolean b2 = bj.b(this);
        boolean z = bg.a().m821a() > 0;
        boolean z2 = !m762b();
        boolean h2 = m753h();
        boolean z3 = !m752g();
        boolean z4 = b2 && z && z2 && h2 && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(h2), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m759a(int i2) {
        return this.f847a.m861a(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public j m760b() {
        return this.f846a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m761b() {
        o.a(getApplicationContext()).m858d();
        Iterator it = new ArrayList(this.f850a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).a();
        }
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        fh.a().b(fwVar);
        c(true);
        this.f845a.m835a();
        if (!eu.m463a() && !m754i()) {
            com.xiaomi.channel.commonutils.logger.b.m182a("reconnection successful, reactivate alarm.");
            eu.a(true);
        }
        Iterator<bg.b> it = bg.a().m822a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (!this.f852a && com.xiaomi.push.m.m735a(getApplicationContext())) {
            al.a(getApplicationContext()).a(new cm(this));
        }
    }

    public void b(j jVar) {
        this.f847a.a(jVar.a, jVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m762b() {
        try {
            Class<?> a2 = v.a(this, "miui.os.Build");
            return a2.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean(null) || a2.getField("IS_CT_CUSTOMIZATION_TEST").getBoolean(null);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m763c() {
        fw fwVar = this.f836a;
        return fwVar != null && fwVar.m505c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m764d() {
        fw fwVar = this.f836a;
        return fwVar != null && fwVar.m504b();
    }

    public IBinder onBind(Intent intent) {
        return this.f834a.getBinder();
    }

    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        v.a((Context) this);
        t a2 = u.m870a((Context) this);
        if (a2 != null) {
            ae.a(a2.a);
        }
        if (com.xiaomi.push.m.m735a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f839a = new a(this, null);
            registerReceiver(this.f839a, new IntentFilter(bk.p), null, handler);
            b = true;
            handler.post(new cn(this));
        }
        this.f834a = new Messenger(new co(this));
        bl.a(this);
        cp cpVar = new cp(this, null, 5222, "xiaomi.com", null);
        this.f837a = cpVar;
        cpVar.a(true);
        this.f835a = new fs(this, this.f837a);
        this.f846a = m756a();
        eu.a(this);
        this.f835a.a(this);
        this.f844a = new be(this);
        this.f845a = new bq(this);
        new k().a();
        fh.m474a().a(this);
        this.f847a = new p("Connection Controller Thread");
        bg a3 = bg.a();
        a3.b();
        a3.a(new cq(this));
        if (k()) {
            h();
        }
        hg.a(this).a(new r(this), "UPLOADER_PUSH_CHANNEL");
        a(new hd(this));
        a(new cg(this));
        if (com.xiaomi.push.m.m735a((Context) this)) {
            a(new bf());
        }
        a(new h());
        this.f851a.add(bx.a(this));
        if (m753h()) {
            this.f840a = new f();
            registerReceiver(this.f840a, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
        if (com.xiaomi.push.m.m735a(getApplicationContext())) {
            this.f843a = new t();
            registerReceiver(this.f843a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
            k kVar = new k();
            this.f841a = kVar;
            registerReceiver(kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
        }
        o.a(getApplicationContext()).m854a();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f833a = new cr(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f833a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] a4 = m749a();
            if (a4 != null) {
                this.f842a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f842a, intentFilter);
                this.a = a4[0];
                this.f853b = a4[1];
                com.xiaomi.channel.commonutils.logger.b.m182a("falldown initialized: " + this.a + "," + this.f853b);
            }
        }
        String str = "";
        if (a2 != null) {
            try {
                if (!TextUtils.isEmpty(a2.f996a) && (split = a2.f996a.split(o70.DINAMIC_PREFIX_AT)) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        dd.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.h.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    public void onDestroy() {
        f fVar = this.f840a;
        if (fVar != null) {
            a(fVar);
            this.f840a = null;
        }
        t tVar = this.f843a;
        if (tVar != null) {
            a(tVar);
            this.f843a = null;
        }
        k kVar = this.f841a;
        if (kVar != null) {
            a(kVar);
            this.f841a = null;
        }
        r rVar = this.f842a;
        if (rVar != null) {
            a(rVar);
            this.f842a = null;
        }
        a aVar = this.f839a;
        if (aVar != null) {
            a(aVar);
            this.f839a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f833a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f833a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f851a.clear();
        this.f847a.m862b();
        a(new ck(this, 2));
        a(new l());
        bg.a().b();
        bg.a().a(this, 15);
        bg.a().m825a();
        this.f835a.b(this);
        bv.a().m840a();
        eu.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m182a("Service destroyed");
    }

    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.m182a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bk.t), intent.getStringExtra(bk.B), intent.getStringExtra("mipush_app_package")));
        }
        if (!(intent == null || intent.getAction() == null)) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f847a.m860a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    bg.a().a(this, 14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                if ("10".equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("rx_msg", System.currentTimeMillis());
                    intent.putExtra("screen_on", w.a(getApplicationContext()));
                    intent.putExtra("wifi", bj.e(getApplicationContext()));
                }
                iVar = new i(intent);
            }
            a(iVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }
}
