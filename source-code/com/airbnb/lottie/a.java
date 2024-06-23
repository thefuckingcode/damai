package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.kb1;
import tb.na1;
import tb.o91;
import tb.um0;
import tb.zm0;

/* compiled from: Taobao */
public class a {
    private final PerformanceTracker a = new PerformanceTracker();
    private final HashSet<String> b = new HashSet<>();
    private Map<String, List<Layer>> c;
    private Map<String, na1> d;
    private Map<String, um0> e;
    private List<kb1> f;
    private SparseArrayCompat<zm0> g;
    private LongSparseArray<Layer> h;
    private List<Layer> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private int o = 0;

    @Deprecated
    /* compiled from: Taobao */
    public static class b {

        /* renamed from: com.airbnb.lottie.a$b$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        private static final class C0065a implements LottieListener<a>, Cancellable {
            private final OnCompositionLoadedListener a;
            private boolean b;

            /* renamed from: a */
            public void onResult(a aVar) {
                if (!this.b) {
                    this.a.onCompositionLoaded(aVar);
                }
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.b = true;
            }

            private C0065a(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.b = false;
                this.a = onCompositionLoadedListener;
            }
        }

        @Deprecated
        public static Cancellable a(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            C0065a aVar = new C0065a(onCompositionLoadedListener);
            b.d(context, str).f(aVar);
            return aVar;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        o91.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.j;
    }

    public SparseArrayCompat<zm0> c() {
        return this.g;
    }

    public float d() {
        return (float) ((long) ((e() / this.m) * 1000.0f));
    }

    public float e() {
        return this.l - this.k;
    }

    public float f() {
        return this.l;
    }

    public Map<String, um0> g() {
        return this.e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, na1> i() {
        return this.d;
    }

    public List<Layer> j() {
        return this.i;
    }

    @Nullable
    public kb1 k(String str) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            kb1 kb1 = this.f.get(i2);
            if (kb1.a(str)) {
                return kb1;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int l() {
        return this.o;
    }

    public PerformanceTracker m() {
        return this.a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> n(String str) {
        return this.c.get(str);
    }

    public float o() {
        return this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean p() {
        return this.n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void q(int i2) {
        this.o += i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, na1> map2, SparseArrayCompat<zm0> sparseArrayCompat, Map<String, um0> map3, List<kb1> list2) {
        this.j = rect;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.i = list;
        this.h = longSparseArray;
        this.c = map;
        this.d = map2;
        this.g = sparseArrayCompat;
        this.e = map3;
        this.f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer s(long j2) {
        return this.h.get(j2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.i) {
            sb.append(layer.w("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}
