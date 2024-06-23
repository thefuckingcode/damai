package tb;

import androidx.annotation.NonNull;
import com.taobao.phenix.cache.disk.DiskCache;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import com.taobao.phenix.request.a;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.produce.BaseChainProducer;

/* compiled from: Taobao */
public abstract class z9<OUT, NEXT_OUT extends Releasable> extends BaseChainProducer<OUT, NEXT_OUT, a> {
    private final DiskCacheSupplier j;

    public z9(int i, int i2, DiskCacheSupplier diskCacheSupplier) {
        super(i, i2);
        this.j = diskCacheSupplier;
    }

    private r02 I(int i, String str, int i2, int[] iArr) {
        int i3;
        DiskCache K = K(i);
        if (!K.open(tp1.o().applicationContext())) {
            vr2.i("DiskCache", "%s open failed in DiskCacheReader", K);
            return null;
        } else if (!K.isSupportCatalogs() || (i3 = iArr[0]) == 1) {
            return K.get(str, i2);
        } else {
            int[] catalogs = K.getCatalogs(str);
            if (catalogs == null || catalogs.length <= 0) {
                vr2.a("DiskCache", "find catalogs failed, key=%s", str);
                return null;
            }
            int[] H = H(catalogs, i2);
            int i4 = H[0];
            if (!a.W(i3, i4)) {
                return null;
            }
            iArr[0] = i4;
            vr2.a("DiskCache", "find best size level=%d, actual=%d, target=%d, key=%s", Integer.valueOf(i4), Integer.valueOf(pb2.e(H[1])), Integer.valueOf(pb2.e(i2)), str);
            return K.get(str, H[1]);
        }
    }

    /* access modifiers changed from: protected */
    public int[] H(int[] iArr, int i) {
        int e = pb2.e(i);
        int d = pb2.d(i);
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = 2;
        while (true) {
            if (i4 >= length) {
                break;
            }
            int i6 = iArr[i4];
            int e2 = pb2.e(i6) - e;
            int d2 = pb2.d(i6) - d;
            int abs = Math.abs(e2) + Math.abs(d2);
            if (abs == 0) {
                i2 = i6;
                i5 = 1;
                break;
            }
            if (i5 == 2 && e2 > 0 && d2 > 0) {
                i2 = i6;
                i3 = abs;
                i5 = 4;
            } else if ((i5 != 4 || (e2 >= 0 && d2 >= 0)) && abs < i3) {
                i2 = i6;
                i3 = abs;
            }
            i4++;
        }
        return new int[]{i5, i2};
    }

    /* access modifiers changed from: protected */
    public pd0 J(@NonNull a aVar, String str, int i, int[] iArr) {
        r02 I = I(aVar.E(), str, i, iArr);
        if (I == null) {
            return null;
        }
        try {
            return pd0.c(I, null);
        } catch (Exception e) {
            vr2.m("DiskCache", aVar, "transform data from response[type:%d] error=%s", Integer.valueOf(I.a), e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public DiskCache K(int i) {
        DiskCache diskCache = this.j.get(i);
        return diskCache == null ? this.j.get(17) : diskCache;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00c2  */
    public int L(a aVar, qd0 qd0, boolean z) {
        int i = 3;
        if (!qd0.a()) {
            vr2.k("DiskCache", aVar, "write skipped, because encode data not available, key=%s, catalog=%d", aVar.D(), Integer.valueOf(aVar.C()));
            i = 1;
        } else if (qd0.i()) {
            vr2.k("DiskCache", aVar, "write skipped, because encode data not need to be cached(fromDisk=%b, fromScale=%b), key=%s, catalog=%d", Boolean.valueOf(qd0.k), Boolean.valueOf(qd0.j), aVar.D(), Integer.valueOf(aVar.C()));
            i = 2;
        } else {
            DiskCache K = K(aVar.E());
            if (K.open(tp1.o().applicationContext())) {
                boolean put = K.put(aVar.D(), aVar.C(), qd0.c, qd0.d, qd0.b);
                int i2 = !put ? 4 : 0;
                vr2.k("DiskCache", aVar, "write result=%B，priority=%d, key=%s, catalog=%d", Boolean.valueOf(put), Integer.valueOf(aVar.E()), aVar.D(), Integer.valueOf(aVar.C()));
                i = i2;
            } else {
                vr2.i("DiskCache", "%s open failed in DiskCacheWriter", K);
            }
            if (z) {
                qd0.release();
            }
            return i;
        }
        if (z) {
        }
        return i;
    }
}
