package com.taobao.pexode;

import android.graphics.BitmapFactory;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.common.DegradeEventListener;
import com.taobao.pexode.entity.IncrementalStaging;
import com.taobao.tcommon.core.BytesPool;
import tb.kg0;
import tb.np1;

/* compiled from: Taobao */
public class a implements DegradeEventListener {
    public boolean a;
    public boolean b;
    int c;
    int d;
    int e;
    private BytesPool f;

    /* access modifiers changed from: private */
    /* renamed from: com.taobao.pexode.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0223a {
        private static final a a = new a();
    }

    private int a(int i, boolean z) {
        return ((i << 1) + (z ? 1 : 0)) & 1023;
    }

    public static boolean b(PexodeOptions pexodeOptions) {
        return pexodeOptions.cancelled;
    }

    private int c(int i) {
        int i2 = (i - ((i >> 1) & -613566757)) - ((i >> 2) & 1227133513);
        return (-954437177 & (i2 + (i2 >> 3))) % 63;
    }

    public static IncrementalStaging d(PexodeOptions pexodeOptions) {
        return pexodeOptions.mIncrementalStaging;
    }

    public static int e(PexodeOptions pexodeOptions) {
        return pexodeOptions.lastSampleSize;
    }

    public static a f() {
        return C0223a.a;
    }

    public static boolean i(np1 np1, PexodeOptions pexodeOptions) {
        return pexodeOptions.cancelled || j(np1, pexodeOptions);
    }

    public static boolean j(np1 np1, PexodeOptions pexodeOptions) {
        return (pexodeOptions.justDecodeBounds && pexodeOptions.isSizeAvailable()) || (pexodeOptions.incrementalDecode && pexodeOptions.mIncrementalStaging != null) || !(np1 == null || (np1.a == null && np1.b == null));
    }

    public static void l(PexodeOptions pexodeOptions, IncrementalStaging incrementalStaging) {
        pexodeOptions.mIncrementalStaging = incrementalStaging;
    }

    public static void m(PexodeOptions pexodeOptions, int i) {
        pexodeOptions.lastSampleSize = i;
    }

    public static void n(PexodeOptions pexodeOptions, BitmapFactory.Options options) {
        pexodeOptions.setUponSysOptions(options);
    }

    public byte[] g(int i) {
        BytesPool bytesPool = this.f;
        byte[] offer = bytesPool != null ? bytesPool.offer(i) : null;
        return offer == null ? new byte[i] : offer;
    }

    public void h(byte[] bArr) {
        BytesPool bytesPool = this.f;
        if (bytesPool != null) {
            bytesPool.release(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(BytesPool bytesPool) {
        this.f = bytesPool;
    }

    @Override // com.taobao.pexode.common.DegradeEventListener
    public synchronized void onDegraded2NoAshmem(boolean z) {
        if (!this.b) {
            int a2 = a(this.d, z);
            this.d = a2;
            if (c(a2) >= 8) {
                this.b = true;
                kg0.i(Pexode.TAG, "auto degrading to no ashmem, history=%d", Integer.valueOf(this.d));
                Pexode.ForcedDegradationListener h = Pexode.h();
                if (h != null) {
                    h.onForcedDegrade2NoAshmem();
                }
            }
        }
    }

    @Override // com.taobao.pexode.common.DegradeEventListener
    public synchronized void onDegraded2NoInBitmap(boolean z) {
        if (!this.a) {
            int a2 = a(this.c, z);
            this.c = a2;
            if (c(a2) >= 8) {
                this.a = true;
                kg0.i(Pexode.TAG, "auto degrading to no inBitmap, history=%d", Integer.valueOf(this.c));
                Pexode.ForcedDegradationListener h = Pexode.h();
                if (h != null) {
                    h.onForcedDegrade2NoInBitmap();
                }
            }
        }
    }

    @Override // com.taobao.pexode.common.DegradeEventListener
    public synchronized void onDegraded2System(boolean z) {
        if (!Pexode.k()) {
            int a2 = a(this.e, z);
            this.e = a2;
            if (c(a2) >= 8) {
                Pexode.f(true);
                Pexode.ForcedDegradationListener h = Pexode.h();
                if (h != null) {
                    h.onForcedDegrade2System();
                }
            }
        }
    }
}
