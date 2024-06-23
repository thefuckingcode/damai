package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.mapcore.util.dc;
import com.amap.api.mapcore.util.eu;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public abstract class et {
    private eu a;
    private eu.a b;
    protected boolean c = false;
    protected Resources d;
    private boolean e = false;
    private final Object f = new Object();
    private c g = null;

    /* compiled from: Taobao */
    public class a extends dq<Boolean, Void, Bitmap> {
        private final WeakReference<dc.a> e;

        public a(dc.a aVar) {
            this.e = new WeakReference<>(aVar);
        }

        private dc.a e() {
            dc.a aVar = this.e.get();
            if (this == et.c(aVar)) {
                return aVar;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void b(Bitmap bitmap) {
            super.b((Object) bitmap);
            synchronized (et.this.f) {
                try {
                    et.this.f.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        /* access modifiers changed from: protected */
        public Bitmap a(Boolean... boolArr) {
            try {
                boolean booleanValue = boolArr[0].booleanValue();
                dc.a aVar = this.e.get();
                if (aVar == null) {
                    return null;
                }
                String str = aVar.a + "-" + aVar.b + "-" + aVar.c;
                synchronized (et.this.f) {
                    while (et.this.c && !d()) {
                        et.this.f.wait();
                    }
                }
                Bitmap b = (et.this.a == null || d() || e() == null || et.this.e) ? null : et.this.a.b(str);
                if (booleanValue && b == null && !d() && e() != null && !et.this.e) {
                    synchronized (et.class) {
                        b = et.this.a((Object) aVar);
                    }
                }
                if (!(b == null || et.this.a == null)) {
                    et.this.a.a(str, b);
                }
                return b;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void a(Bitmap bitmap) {
            try {
                if (d() || et.this.e) {
                    bitmap = null;
                }
                dc.a e2 = e();
                if (bitmap != null && !bitmap.isRecycled() && e2 != null) {
                    e2.a(bitmap);
                    if (et.this.g != null) {
                        et.this.g.a();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class b extends dq<Object, Void, Void> {
        protected b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Void a(Object... objArr) {
            try {
                int intValue = ((Integer) objArr[0]).intValue();
                if (intValue == 0) {
                    et.this.c();
                    return null;
                } else if (intValue == 1) {
                    et.this.b();
                    return null;
                } else if (intValue == 2) {
                    et.this.d();
                    return null;
                } else if (intValue == 3) {
                    et.this.c(((Boolean) objArr[1]).booleanValue());
                    return null;
                } else if (intValue != 4) {
                    return null;
                } else {
                    et.this.e();
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    public interface c {
        void a();
    }

    protected et(Context context) {
        this.d = context.getResources();
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap a(Object obj);

    /* access modifiers changed from: protected */
    public void e() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.a(false);
            this.a.a();
        }
    }

    public void f() {
        new b().c(0);
    }

    /* access modifiers changed from: private */
    public static a c(dc.a aVar) {
        if (aVar != null) {
            return aVar.j;
        }
        return null;
    }

    public void a(boolean z, dc.a aVar) {
        if (aVar != null) {
            Bitmap bitmap = null;
            try {
                if (this.a != null) {
                    bitmap = this.a.a(aVar.a + "-" + aVar.b + "-" + aVar.c);
                }
                if (bitmap != null) {
                    aVar.a(bitmap);
                    return;
                }
                a aVar2 = new a(aVar);
                aVar.j = aVar2;
                aVar2.a(dq.c, Boolean.valueOf(z));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.c();
        }
    }

    public void b(boolean z) {
        synchronized (this.f) {
            this.c = z;
            if (!z) {
                try {
                    this.f.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.b();
        }
    }

    public void d(boolean z) {
        new b().c(3, Boolean.valueOf(z));
    }

    /* access modifiers changed from: protected */
    public void c(boolean z) {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.a(z);
            this.a = null;
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.a();
        }
    }

    public void a(eu.a aVar) {
        this.b = aVar;
        this.a = eu.a(aVar);
        new b().c(1);
    }

    public void a(boolean z) {
        this.e = z;
        b(false);
    }

    /* access modifiers changed from: protected */
    public eu a() {
        return this.a;
    }

    public static void a(dc.a aVar) {
        a c2 = c(aVar);
        if (c2 != null) {
            c2.a(true);
        }
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void a(String str) {
        this.b.b(str);
        new b().c(4);
    }
}
