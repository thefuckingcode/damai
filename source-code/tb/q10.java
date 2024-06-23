package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.core.IDXVideoFinder;
import com.taobao.android.dinamicx.videoc.core.IKeyedQueue;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
public class q10 extends n1<xv2, IDXVideoListener> {
    public q10(@NonNull IDXVideoFinder<xv2, IDXVideoListener> iDXVideoFinder, @NonNull Comparator<xv2> comparator, boolean z, boolean z2) {
        super(iDXVideoFinder, comparator, z, z2);
    }

    /* access modifiers changed from: protected */
    @Override // tb.n1
    @NonNull
    public IKeyedQueue<IDXVideoListener> d() {
        return new ny();
    }

    /* access modifiers changed from: protected */
    @Override // tb.n1
    public boolean h(@NonNull List<xv2> list, @NonNull List<xv2> list2) {
        if (list2.size() != list.size()) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).b() != list2.get(i).b()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public List<xv2> c(List<xv2> list, xv2 xv2) {
        ArrayList arrayList = new ArrayList();
        for (xv2 xv22 : list) {
            if (xv22.b() != xv2.b()) {
                arrayList.add(xv22);
            }
        }
        arrayList.add(xv2);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public List<xv2> e(List<xv2> list, xv2 xv2) {
        ArrayList arrayList = new ArrayList();
        for (xv2 xv22 : list) {
            if (xv22.b() != xv2.b()) {
                arrayList.add(xv22);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public List<IDXVideoListener> f(@NonNull xv2 xv2, @NonNull List<xv2> list, @NonNull IKeyedQueue<IDXVideoListener> iKeyedQueue) {
        ArrayList arrayList = new ArrayList();
        for (IDXVideoListener iDXVideoListener : iKeyedQueue.toList()) {
            Integer keyOf = iKeyedQueue.keyOf(iDXVideoListener);
            if (keyOf == null || keyOf.intValue() < 0 || keyOf.intValue() > list.size() - 1) {
                return null;
            }
            if (xv2.b() == list.get(keyOf.intValue()).b()) {
                arrayList.add(iDXVideoListener);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public int g(@NonNull xv2 xv2) {
        return xv2.b();
    }
}
