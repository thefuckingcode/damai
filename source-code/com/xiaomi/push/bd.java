package com.xiaomi.push;

import android.os.IBinder;
import com.xiaomi.push.bb;

/* compiled from: Taobao */
class bd implements Runnable {
    final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bb.b f128a;

    bd(bb.b bVar, IBinder iBinder) {
        this.f128a = bVar;
        this.a = iBinder;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x009d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0073 */
    public void run() {
        try {
            String packageName = bb.this.f123a.getPackageName();
            String str = bb.this.b();
            bb.a aVar = new bb.a();
            aVar.f127a = bb.c.a(this.a, packageName, str, "GUID");
            aVar.b = bb.c.a(this.a, packageName, str, "OUID");
            aVar.c = bb.c.a(this.a, packageName, str, "DUID");
            aVar.d = bb.c.a(this.a, packageName, str, "AUID");
            bb.this.f125a = aVar;
            bb.this.m276b();
            bb.this.f122a = 2;
            synchronized (bb.this.f126a) {
                bb.this.f126a.notifyAll();
            }
        } catch (Exception unused) {
            bb.this.m276b();
            bb.this.f122a = 2;
            synchronized (bb.this.f126a) {
                bb.this.f126a.notifyAll();
            }
        } catch (Throwable th) {
            bb.this.m276b();
            bb.this.f122a = 2;
            synchronized (bb.this.f126a) {
                bb.this.f126a.notifyAll();
                throw th;
            }
        }
    }
}
