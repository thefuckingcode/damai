package com.taobao.aranger.utils;

import android.net.Uri;
import android.os.IBinder;
import com.taobao.aranger.exception.IPCException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import tb.jz0;
import tb.kz0;
import tb.xg;

/* compiled from: Taobao */
public class IPCRecycle {
    private static final String c = "IPCRecycle";
    private static volatile IPCRecycle d;
    private final ReferenceQueue<Object> a = new ReferenceQueue<>();
    private final ConcurrentHashMap<PhantomReference<Object>, String> b = new ConcurrentHashMap<>();

    private IPCRecycle() {
    }

    public static IPCRecycle b() {
        if (d == null) {
            synchronized (IPCRecycle.class) {
                if (d == null) {
                    d = new IPCRecycle();
                }
            }
        }
        return d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(Object obj) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            while (true) {
                PhantomReference phantomReference = (PhantomReference) this.a.poll();
                if (phantomReference != null) {
                    String remove = this.b.remove(phantomReference);
                    if (remove != null) {
                        arrayList.add(remove);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            try {
                if (obj instanceof IBinder) {
                    xg.a((IBinder) obj).b(arrayList);
                } else if (obj instanceof Uri) {
                    xg.b((Uri) obj).e(arrayList);
                }
            } catch (IPCException e) {
                jz0.c(c, "[recycle][recycleClient]", e, new Object[0]);
            }
        }
    }

    public void d(final Object obj, Object obj2, String str) {
        this.b.put(new PhantomReference<>(obj2, this.a), str);
        kz0.b(false, false, new Runnable() {
            /* class com.taobao.aranger.utils.IPCRecycle.AnonymousClass1 */

            public void run() {
                IPCRecycle.this.c(obj);
            }
        });
    }
}
