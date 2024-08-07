package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Taobao */
public class ih extends id {
    private static ih c;
    private jj d;
    private Handler e;

    /* renamed from: com.amap.api.mapcore.util.ih$1  reason: invalid class name */
    /* compiled from: Taobao */
    class AnonymousClass1 extends jk {
        final /* synthetic */ ii a;
        final /* synthetic */ boolean b;
        final /* synthetic */ ij c;
        final /* synthetic */ ih d;

        @Override // com.amap.api.mapcore.util.jk
        public void runTask() {
            try {
                this.d.a((ih) this.d.c(this.a, this.b), (ik) this.c);
            } catch (gb e) {
                this.d.a((ih) e, (gb) this.c);
            }
        }
    }

    /* compiled from: Taobao */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, AnonymousClass1 r2) {
            this(looper);
        }

        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    ((im) message.obj).b.a();
                } else if (i == 1) {
                    im imVar = (im) message.obj;
                    imVar.b.a(imVar.a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    private ih(boolean z, int i) {
        if (z) {
            try {
                this.d = jj.b(i);
            } catch (Throwable th) {
                hd.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), null);
        } else {
            this.e = new a();
        }
    }

    public static ih b() {
        return a(true, 5);
    }

    public ik c(ii iiVar, boolean z) throws gb {
        ik ikVar;
        byte[] bArr;
        int a2 = ig.a(2, iiVar);
        try {
            ikVar = c(iiVar, z, a2);
        } catch (gb e2) {
            if (ig.a(a2)) {
                ikVar = null;
            } else {
                throw e2;
            }
        }
        if ((ikVar != null && (bArr = ikVar.a) != null && bArr.length > 0) || !ig.a(a2)) {
            return ikVar;
        }
        try {
            return c(iiVar, z, 3);
        } catch (gb e3) {
            throw e3;
        }
    }

    public byte[] d(ii iiVar) throws gb {
        try {
            ik c2 = c(iiVar, false);
            if (c2 != null) {
                return c2.a;
            }
            return null;
        } catch (gb e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] e(ii iiVar) throws gb {
        try {
            ik c2 = c(iiVar, true);
            if (c2 != null) {
                return c2.a;
            }
            return null;
        } catch (gb e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    @Override // com.amap.api.mapcore.util.id
    public byte[] b(ii iiVar) throws gb {
        try {
            ik a2 = a(iiVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (gb e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            hd.e().b(th, "NetManager", "makeSyncPostRequest");
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    public static ih a(boolean z) {
        return a(z, 5);
    }

    private static synchronized ih a(boolean z, int i) {
        ih ihVar;
        synchronized (ih.class) {
            try {
                ih ihVar2 = c;
                if (ihVar2 == null) {
                    c = new ih(z, i);
                } else if (z && ihVar2.d == null) {
                    ihVar2.d = jj.b(i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (gg.b() == null) {
                    gg.a(gt.a());
                }
            } catch (Throwable unused) {
            }
            ihVar = c;
        }
        return ihVar;
    }

    public Map<String, String> b(ii iiVar, boolean z) throws gb {
        Map<String, String> map;
        int a2 = ig.a(2, iiVar);
        try {
            map = b(iiVar, z, a2);
        } catch (gb e2) {
            if (ig.a(a2)) {
                map = null;
            } else {
                throw e2;
            }
        }
        if (map != null || !ig.a(a2)) {
            return map;
        }
        try {
            return b(iiVar, z, 3);
        } catch (gb e3) {
            throw e3;
        }
    }

    public ik c(ii iiVar, boolean z, int i) throws gb {
        try {
            c(iiVar);
            Proxy proxy = iiVar.c;
            if (proxy == null) {
                proxy = null;
            }
            return new ig(iiVar.a, iiVar.b, proxy, z).b(iiVar.getURL(), iiVar.c(), iiVar.isIPRequest(), iiVar.getIPDNSName(), iiVar.getRequestHead(), iiVar.getParams(), iiVar.isIgnoreGZip(), i);
        } catch (gb e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(gb gbVar, ij ijVar) {
        im imVar = new im();
        imVar.a = gbVar;
        imVar.b = ijVar;
        Message obtain = Message.obtain();
        obtain.obj = imVar;
        obtain.what = 1;
        this.e.sendMessage(obtain);
    }

    public Map<String, String> b(ii iiVar, boolean z, int i) throws gb {
        try {
            c(iiVar);
            Proxy proxy = iiVar.c;
            if (proxy == null) {
                proxy = null;
            }
            return new ig(iiVar.a, iiVar.b, proxy, z).a(iiVar.getURL(), iiVar.c(), iiVar.isIPRequest(), iiVar.getIPDNSName(), iiVar.getRequestHead(), iiVar.getParams(), iiVar.isIgnoreGZip(), i);
        } catch (gb e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(ik ikVar, ij ijVar) {
        ijVar.a(ikVar.b, ikVar.a);
        im imVar = new im();
        imVar.b = ijVar;
        Message obtain = Message.obtain();
        obtain.obj = imVar;
        obtain.what = 0;
        this.e.sendMessage(obtain);
    }
}
