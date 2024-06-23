package com.efs.sdk.base.a.e;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.b.f;
import com.efs.sdk.base.a.b.g;
import com.efs.sdk.base.a.e.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import tb.g23;
import tb.j13;
import tb.k53;
import tb.l23;
import tb.n13;
import tb.o13;
import tb.s23;
import tb.t43;
import tb.u33;
import tb.u43;
import tb.w23;

/* compiled from: Taobao */
public final class a extends Handler {
    public int a;
    public c b;
    private c c;
    private List<String> d;
    private AtomicInteger e;
    private f f;

    /* access modifiers changed from: package-private */
    /* renamed from: com.efs.sdk.base.a.e.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0152a {
        private static final a a = new a((byte) 0);
    }

    private a() {
        super(o13.a.getLooper());
        this.a = 5;
        this.d = new ArrayList();
        this.e = new AtomicInteger(0);
        this.b = new j13();
        this.c = new u43();
        this.f = new g();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0152a.a;
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj, int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        obtain.arg1 = i;
        sendMessage(obtain);
    }

    public final void handleMessage(Message message) {
        List<File> list;
        super.handleMessage(message);
        if (f.a.a.b()) {
            int i = message.what;
            if (i == 0) {
                String a2 = s23.a.a().a();
                if ("denied".equalsIgnoreCase(a2) || "disconnected".equalsIgnoreCase(a2)) {
                    t43.a("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(a2)));
                    sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().m);
                    return;
                }
                List<g23> emptyList = Collections.emptyList();
                try {
                    com.efs.sdk.base.a.b.a aVar = a.b.a;
                    int i2 = this.a;
                    com.efs.sdk.base.a.b.f fVar = this.f;
                    aVar.b();
                    aVar.b();
                    File g = n13.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a);
                    if (!g.exists()) {
                        list = Collections.emptyList();
                    } else {
                        List<File> k = w23.k(g);
                        if (aVar.b) {
                            k53 k53 = k53.a.a;
                            int size = k.size();
                            if (k53.b != null) {
                                if (com.efs.sdk.base.a.d.a.a().d) {
                                    l23 l23 = new l23("efs_core", "log_lag", k53.a.c);
                                    l23.a("cnt", Integer.valueOf(size));
                                    k53.b.b(l23);
                                }
                            }
                            aVar.b = false;
                        }
                        Collections.sort(k, aVar.d);
                        ArrayList arrayList = new ArrayList(i2);
                        for (int size2 = k.size() - 1; size2 >= 0 && arrayList.size() < i2; size2--) {
                            File file = k.get(size2);
                            if (file.exists() && (fVar == null || !fVar.a(file))) {
                                arrayList.add(file);
                            }
                        }
                        list = arrayList;
                    }
                    ArrayList arrayList2 = new ArrayList(i2);
                    for (File file2 : list) {
                        g23 a3 = aVar.a(file2);
                        if (a3 == null) {
                            t43.b("efs.cache", "file upload error, name is " + file2.getName(), null);
                        } else {
                            arrayList2.add(a3);
                        }
                    }
                    emptyList = arrayList2;
                } catch (Throwable unused) {
                }
                for (g23 g23 : emptyList) {
                    if (Constants.LOG_TYPE_WA.equals(g23.a.a) || b.b().e(g23.a.a, g23.a())) {
                        c cVar = this.b;
                        if (Constants.LOG_TYPE_WA.equals(g23.a.a)) {
                            cVar = this.c;
                        }
                        String uuid = UUID.randomUUID().toString();
                        this.d.add(uuid);
                        if (u33.a(new e(g23, cVar, uuid)) == null) {
                            b(uuid, -1);
                        }
                    }
                }
                if (this.d.size() <= 0) {
                    sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().m);
                }
            } else if (i == 1) {
                Object obj = message.obj;
                if (obj != null) {
                    this.d.remove(obj.toString());
                }
                int incrementAndGet = message.arg1 != 0 ? this.e.incrementAndGet() : 0;
                if (!this.d.isEmpty()) {
                    return;
                }
                if (incrementAndGet < 5) {
                    sendEmptyMessage(0);
                    return;
                }
                this.e.set(0);
                sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().l);
                t43.a("efs.send_log", "request error cnt gt 5, next request delay 10s");
            }
        }
    }
}
